/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Vladimir Bernardo
 */
public class SSSDeduction implements Deduction {
    @Override
    public double calculate(double gross) {
        // Simplified Philippine SSS logic
        if (gross >= 24750) return 1125.00;
        return gross * 0.045;
    }
    @Override
    public String getName() { return "SSS"; }
}
