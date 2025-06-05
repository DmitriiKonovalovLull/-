package com.cnc.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cutting-modes")
public class CuttingModeController {

    /**
     * GET /api/cutting-modes/calculate
     * @param diameter Диаметр детали (мм)
     * @param vc Скорость резания (м/мин)
     * @param feedPerRev Подача на оборот (мм/об)
     * @return JSON с рассчитанными оборотами и подачей
     */
    @GetMapping("/calculate")
    public CuttingResult calculate(
            @RequestParam double diameter,
            @RequestParam double vc,
            @RequestParam double feedPerRev) {

        double rpm = (1000 * vc) / (Math.PI * diameter);
        double feedRate = rpm * feedPerRev;

        return new CuttingResult(rpm, feedRate);
    }

    static class CuttingResult {
        private final double rpm;
        private final double feedRate;

        public CuttingResult(double rpm, double feedRate) {
            this.rpm = rpm;
            this.feedRate = feedRate;
        }

        public double getRpm() {
            return rpm;
        }

        public double getFeedRate() {
            return feedRate;
        }
    }
}
