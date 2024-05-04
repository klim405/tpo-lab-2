package org.klim405;

import org.klim405.logarithms.Ln;
import org.klim405.logarithms.Log;
import org.klim405.trigonometry.Cos;
import org.klim405.trigonometry.Ctg;
import org.klim405.trigonometry.Sec;
import org.klim405.trigonometry.Sin;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    private static void save(String moduleName, List<Double> x, List<Double> y) throws IOException {
        Path path = Paths.get("csv/" + moduleName + ".csv");
        List<String> lines = new ArrayList<>();
        lines.add("x, y");
        for (int i = 0; i < x.size(); i++) {
            lines.add(x.get(i) + ", " + (y.get(i) == null ? "NaN" : y.get(i)));
        }
        if (!Files.exists(path)) {
            Files.createDirectories(path.getParent());
            Files.createFile(path);
        }
        Files.write(path, lines);
    }

    public static Double getValue(MathFunc func, double val) {
        try {
            return func.calcDouble(val);
        } catch (NullPointerException | ArithmeticException ignore) {}
        return null;
    }

    public static void addValue(List<Double> list, MathFunc func, double val) {
        list.add(getValue(func, val));
    }

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter step: ");
        double step = Double.valueOf(input.nextLine());

        List<Double> xVals = new ArrayList<>();
        List<Double> ySin = new ArrayList<>();
        List<Double> ySec = new ArrayList<>();
        List<Double> yCos = new ArrayList<>();
        List<Double> yCtg = new ArrayList<>();
        List<Double> yLn = new ArrayList<>();
        List<Double> yLog = new ArrayList<>();
        List<Double> yF = new ArrayList<>();

        Cos cos = new Cos();
        Sin sin = new Sin();
        Sec sec = new Sec(cos);
        Ctg ctg = new Ctg(sin, cos);
        Ln ln = new Ln();
        Log log = new Log(ln, 2);
        FunctionSystem f = new FunctionSystem();

        double x = -step*5;
        for (int i = 0; i < 10; i++) {
            xVals.add(x);
            addValue(yCos, cos, x);
            addValue(ySin, sin, x);
            addValue(yCtg, ctg, x);
            addValue(ySec, sec, x);
            addValue(yLn, ln, x);
            addValue(yLog, log, x);
            addValue(yF, f, x);
            x += step;
        }

        save("sin", xVals, ySin);
        save("cos", xVals, yCos);
        save("ctg", xVals, yCtg);
        save("sec", xVals, ySec);
        save("log", xVals, yLog);
        save("ln", xVals, yLn);
        save("f", xVals, yF);
    }
}
