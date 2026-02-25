package com.amis.mes.pro.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.amis.common.annotation.Log;
import com.amis.common.core.controller.BaseController;
import com.amis.common.core.domain.AjaxResult;
import com.amis.common.enums.BusinessType;
import com.amis.mes.pro.domain.ProWorkorderBom;
import com.amis.mes.pro.service.IProWorkorderBomService;
import com.amis.common.utils.poi.ExcelUtil;
import com.amis.common.core.page.TableDataInfo;

/**
 * 生产工单BOM组成Controller
 * 
 * @author yinjinlu
 * @date 2022-05-09
 */
@RestController
@RequestMapping("/mes/pro/workorderbom")
public class ProWorkorderBomController extends BaseController
{
    @Autowired
    private IProWorkorderBomService proWorkorderBomService;

    /**
     * 查询生产工单BOM组成列表
     */
    @GetMapping("/list")
    public TableDataInfo list(ProWorkorderBom proWorkorderBom)
    {
        startPage();
        List<ProWorkorderBom> list = proWorkorderBomService.selectProWorkorderBomList(proWorkorderBom);
        return getDataTable(list);
    }

    /**
     * 导出生产工单BOM组成列表
     */
    @PreAuthorize("@ss.hasPermi('mes:pro:workorder:export')")
    @Log(title = "生产工单BOM组成", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ProWorkorderBom proWorkorderBom)
    {
        List<ProWorkorderBom> list = proWorkorderBomService.selectProWorkorderBomList(proWorkorderBom);
        ExcelUtil<ProWorkorderBom> util = new ExcelUtil<ProWorkorderBom>(ProWorkorderBom.class);
        util.exportExcel(response, list, "生产工单BOM组成数据");
    }

    /**
     * 获取生产工单BOM组成详细信息
     */
    @PreAuthorize("@ss.hasPermi('mes:pro:workorder:query')")
    @GetMapping(value = "/{lineId}")
    public AjaxResult getInfo(@PathVariable("lineId") Long lineId)
    {
        return AjaxResult.success(proWorkorderBomService.selectProWorkorderBomByLineId(lineId));
    }

    /**
     * 新增生产工单BOM组成
     */
    @PreAuthorize("@ss.hasPermi('mes:pro:workorder:add')")
    @Log(title = "生产工单BOM组成", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ProWorkorderBom proWorkorderBom)
    {
        return toAjax(proWorkorderBomService.insertProWorkorderBom(proWorkorderBom));
    }

    /**
     * 修改生产工单BOM组成
     */
    @PreAuthorize("@ss.hasPermi('mes:pro:workorder:edit')")
    @Log(title = "生产工单BOM组成", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ProWorkorderBom proWorkorderBom)
    {
        return toAjax(proWorkorderBomService.updateProWorkorderBom(proWorkorderBom));
    }

    /**
     * 删除生产工单BOM组成
     */
    @PreAuthorize("@ss.hasPermi('mes:pro:workorder:remove')")
    @Log(title = "生产工单BOM组成", businessType = BusinessType.DELETE)
	@DeleteMapping("/{lineIds}")
    public AjaxResult remove(@PathVariable Long[] lineIds)
    {
        return toAjax(proWorkorderBomService.deleteProWorkorderBomByLineIds(lineIds));
    }
}
