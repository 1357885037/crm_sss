package com.hy.crm.controller;


import com.hy.crm.service.IWithsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author mq
 * @since 2020-04-03
 */
@RestController
@RequestMapping("/crm/withs")
public class WithsController {

    @Autowired
    private IWithsService withsService;

    @RequestMapping("/sumMeonkey.do")
    public Double sumMeonkey() {
        Double d;
        try {
            d=withsService.sumMeonkey();
        } catch (Exception e) {
            e.printStackTrace();
            d=0.0;
        }
        return d;
    }
    @RequestMapping("/sumSMeonkey.do")
    public Double sumSMeonkey() {
        Double d;
        try {
            d=withsService.sumSMeonkey();
        } catch (Exception e) {
            e.printStackTrace();
            d=0.0;
        }
        return d;
    }
    @RequestMapping("/sumYMeonkey.do")
    public Double sumYMeonkey() {
        Double d;
        try {
            d=withsService.sumYMeonkey();
        } catch (Exception e) {
            e.printStackTrace();
            d=0.0;
        }
        return d;
    }
    @RequestMapping("/sumSYMeonkey.do")
    public Double sumSYMeonkey() {
        Double d;
        try {
            d=withsService.sumSYMeonkey();
        } catch (Exception e) {
            e.printStackTrace();
            d=0.0;
        }
        return d;
    }
    @RequestMapping("/sumJdMeonkey.do")
    public Double sumJdMeonkey() {
        Double d;
        try {
            d=withsService.sumJdMeonkey();
        } catch (Exception e) {
            e.printStackTrace();
            d=0.0;
        }
        return d;
    }
    @RequestMapping("/sumSJdMeonkey.do")
    public Double sumSJdMeonkey() {
        Double d;
        try {
            d=withsService.sumSJdMeonkey();
        } catch (Exception e) {
            e.printStackTrace();
            d=0.0;
        }
        return d;
}
    @RequestMapping("/sumNMeonkey.do")
    public Double sumNMeonkey() {
        Double d;
        try {
            d=withsService.sumNMeonkey();
        } catch (Exception e) {
            e.printStackTrace();
            d=0.0;
        }
        return d;
    }
    @RequestMapping("/sumSNMeonkey.do")
    public Double sumSNMeonkey() {
        Double d;
        try {
            d=withsService.sumSNMeonkey();
        } catch (Exception e) {
            e.printStackTrace();
            d=0.0;
        }
        return d;
    }

}
