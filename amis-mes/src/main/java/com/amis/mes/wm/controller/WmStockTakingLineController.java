package com.amis.mes.wm.controller;

import com.amis.common.annotation.Log;
import com.amis.common.core.controller.BaseController;
import com.amis.common.core.domain.AjaxResult;
import com.amis.common.core.page.TableDataInfo;
import com.amis.common.enums.BusinessType;
import com.amis.common.utils.poi.ExcelUtil;
import com.amis.mes.wm.domain.WmStockTakingLine;
import com.amis.mes.wm.service.IWmStockTakingLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/mes/wm/stocktakingline")
public class WmStockTakingLineController extends BaseController {
    @Autowired
    private IWmStockTakingLineService wmStockTakingLineService;

    /**
     * 查询库存盘点明细列表
     */
    @PreAuthorize("@ss.hasPermi('mes:wm:stocktaking:list')")
    @GetMapping("/list")
    public TableDataInfo list(WmStockTakingLine wmStockTakingLine)
    {
        startPage();
        List<WmStockTakingLine> list = wmStockTakingLineService.selectWmStockTakingLineList(wmStockTakingLine);
        return getDataTable(list);
    }

    /**
     * 导出库存盘点明细列表
     */
    @PreAuthorize("@ss.hasPermi('mes:wm:stocktaking:export')")
    @Log(title = "库存盘点明细", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, WmStockTakingLine wmStockTakingLine)
    {
        List<WmStockTakingLine> list = wmStockTakingLineService.selectWmStockTakingLineList(wmStockTakingLine);
        ExcelUtil<WmStockTakingLine> util = new ExcelUtil<WmStockTakingLine>(WmStockTakingLine.class);
        util.exportExcel(response, list, "库存盘点明细数据");
    }

    /**
     * 获取库存盘点明细详细信息
     */
    @PreAuthorize("@ss.hasPermi('mes:wm:stocktaking:query')")
    @GetMapping(value = "/{lineId}")
    public AjaxResult getInfo(@PathVariable("lineId") Long lineId)
    {
        return AjaxResult.success(wmStockTakingLineService.selectWmStockTakingLineByLineId(lineId));
    }

}
