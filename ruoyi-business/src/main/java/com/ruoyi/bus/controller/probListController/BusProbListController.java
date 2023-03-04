package com.ruoyi.bus.controller.probListController;

import java.util.List;

import com.ruoyi.bus.domain.BusProbImportModel;
import com.ruoyi.bus.domain.probListDomain.*;
import com.ruoyi.bus.service.IUserService;
import com.ruoyi.common.utils.user.CurrentUser;
import com.ruoyi.framework.shiro.session.OnlineSession;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.bus.service.IBusProbListService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * 故障清单Controller
 * 
 * @author LiuYuzhou
 * @date 2023-02-23
 */
@Controller
@RequestMapping("/ruoyi-business/probList")
public class BusProbListController extends BaseController
{
    private String prefix = "ruoyi-business/probList";

    @Autowired
    private IBusProbListService busProbListService;

    @Autowired
    private IUserService userService;

    @RequiresPermissions("ruoyi-business:probList:view")
    @GetMapping()
    public String probList()
    {
        return prefix + "/probList";
    }

    /**
     * 查询故障清单列表
     */
    @RequiresPermissions("ruoyi-business:probList:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(BusProbList busProbList)
    {
        startPage();
        List<BusProbList> list = busProbListService.selectBusProbListList(busProbList);
        return getDataTable(list);
    }

    /**
     * 查看详细
     */
    @GetMapping("/detail/{probListId}")
    public String detail(@PathVariable("probListId") int probListId, ModelMap mmap)
    {
        BusProbList busProbList = busProbListService.selectBusProbListWithAllStarByProbListId(probListId);
        //在detail.html文件中，涉及到复选框额两个无法从后端传入null，所以需要先进行处理再传给前端。和edit方法类似。
        //根本原因是前端使用复选框，导致必须传入值，是前端写法问题。
        if(busProbList.getProbListEvaluation()==null){
            busProbList.setProbListEvaluation("");
        }
        if(busProbList.getProbListTag()==null){
            busProbList.setProbListTag("");
        }
        mmap.put("busProbList", busProbList);
        return prefix + "/detail";
    }

    /**
     * 查看历次流程及更改内容
     *
     * @param probListId
     * @param mmap
     * @return
     */
    @GetMapping("/detail/{probListId}")
    public String processDetail(@PathVariable("probListId") int probListId, ModelMap mmap){
        List<BusProbProcess>  busProbProcessLists = busProbListService.selectAllProcessDetailByProbListId(probListId);
        mmap.put("busProbProcessLists", busProbProcessLists);
        return prefix + "/processDetail";
    }

    /**
     * 下载模板
     */
    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate()
    {
        ExcelUtil<BusProbImportModel> util = new ExcelUtil<BusProbImportModel>(BusProbImportModel.class);
        return util.importTemplateExcel("故障清单数据");
    }

    /**
     * 导入数据
     */
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<BusProbImportModel> util = new ExcelUtil<BusProbImportModel>(BusProbImportModel.class);
        List<BusProbImportModel> probList = util.importExcel(file.getInputStream());
        String message = importProbList(probList, updateSupport);
        return AjaxResult.success(message);
    }

    /**
     * 导出故障清单列表
     */
    @RequiresPermissions("ruoyi-business:probList:export")
    @Log(title = "故障清单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BusProbList busProbList)
    {
        List<BusProbList> list = busProbListService.selectBusProbListWithSubList(busProbList);
        System.out.println("--------------------导出数据为：--------------------------"+list);
        ExcelUtil<BusProbList> util = new ExcelUtil<BusProbList>(BusProbList.class);
        return util.exportExcel(list, "故障清单数据");
    }

    /**
     * 新增故障清单
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 主页新增保存故障清单，只增加主表
     */
    @RequiresPermissions("ruoyi-business:probList:add")
    @Log(title = "故障清单", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(BusProbList busProbList,HttpServletRequest httpServletRequest)
    {
        //把星级列表里的星级信息放到列表外面list里面的属性里,星级是必填的，应该不需要判断null
        BusProbStar busProbStar = busProbList.getBusProbStarList().get(0);
        busProbList.setProbStar(busProbStar.getProbStar());
        return toAjax(busProbListService.insertBusProbList(busProbList));
    }

    /**
     * 修改故障清单，根据角色不同修改不同的内容，也就是跳转到不同的edit页面
     */
    @RequiresPermissions("ruoyi-business:probList:edit")
    @GetMapping("/edit/{probListId}")
    public String edit(@PathVariable("probListId") int probListId, ModelMap mmap, HttpServletRequest httpServletRequest)
    {
        BusProbList busProbList = busProbListService.selectBusProbListByProbListId(probListId);
        //在edit.html文件中，涉及到复选框额两个无法从后端传入null，所以需要先进行处理再传给前端。具体设计语句如下：
        //th:attr="checked=${busProbList.probListEvaluation.contains(dict.dictValue)?true:false}"
        if(busProbList.getProbListEvaluation()==null){
            busProbList.setProbListEvaluation("");
        }
        if(busProbList.getProbListTag()==null){
            busProbList.setProbListTag("");
        }
        mmap.put("busProbList", busProbList);
        List<String> myRole = getMyRole(((OnlineSession)CurrentUser.getWhoAmI(httpServletRequest)).getUserId());
        if (myRole.contains("admin")){
            return prefix + "/adminEdit";
        }else if (myRole.contains("")){
            return prefix + "/edit";    //
        }else{
            return prefix + "/edit";    //
        }
    }

    /**
     * 修改保存主表故障清单
     */
    @RequiresPermissions("ruoyi-business:probList:edit")
    @RequiresRoles("")
    @Log(title = "故障清单", businessType = BusinessType.UPDATE)
    @PostMapping("/editProbList")
    @ResponseBody
    public AjaxResult editProbListSave(BusProbList busProbList)
    {
        BusProbStar busProbStar = busProbList.getBusProbStarList().get(0);
        if(busProbStar.getProbStar() != busProbList.getProbStar()){
            busProbList.setProbStar(busProbStar.getProbStar());
        }else{
            busProbList.setBusProbStarList(null);
        }
        return toAjax(busProbListService.updateBusProbList(busProbList));
    }

    /**
     * 修改保存副表故障清单
     */
    @RequiresPermissions("ruoyi-business:probList:edit")
    @RequiresRoles("")
    @Log(title = "故障清单", businessType = BusinessType.UPDATE)
    @PostMapping("/editSubList")
    @ResponseBody
    public AjaxResult editSubListSave(BusProbProcess busProbProcess, HttpServletRequest httpServletRequest) {
        //判断措施内容不为空，为空不增加措施表
        BusProbTempSolution busProbTempSolution = busProbProcess.getBusProbTempSolutionList().get(0);
        if(busProbTempSolution.getProbTempSolution().equals("")){
            busProbProcess.setBusProbTempSolutionList(null);
        }
        //判断原因内容不为空，为空不增加原因表
        BusProbReason busProbReason = busProbProcess.getBusProbReason();
        if (busProbReason.getProbReason().equals(null)){
            busProbProcess.setBusProbReason(null);
        }
        String changerName = ((OnlineSession)CurrentUser.getWhoAmI(httpServletRequest)).getLoginName();
        return toAjax(busProbListService.updateBusProbSubList(busProbProcess, changerName));
    }

    /**
     * 删除故障清单
     */
    @RequiresPermissions("ruoyi-business:probList:remove")
    @RequiresRoles("")
    @Log(title = "故障清单", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(busProbListService.deleteBusProbListByProbListIds(ids));
    }

    /**
     * 删除流程
     *
     * @param busProcessId
     * @return
     */
    @RequiresRoles("")
    @PostMapping( "/removeProcess")
    @ResponseBody
    public AjaxResult removeProcess(int busProcessId,HttpServletRequest httpServletRequest)
    {
        String loginName = ((OnlineSession)CurrentUser.getWhoAmI(httpServletRequest)).getLoginName();
        return toAjax(busProbListService.deleteBusProbProcessByBusProcessId(busProcessId,loginName));
    }

    /**
     * 导入文件实现方法
     *
     * @param probList
     * @param updateSupport
     * @return
     */
    private String importProbList(List<BusProbImportModel> probList, boolean updateSupport) {

        return "";
    }

    /**
     * 根据用户id获取角色key值：admin，common等
     *
     * @param userId
     * @return
     */
    private List<String> getMyRole(Long userId) {
        return userService.getRoleName(Math.toIntExact(userId));
    }
}
