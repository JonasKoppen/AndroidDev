package koppen.jonas.ap.projectbig;

import java.util.ArrayList;
import java.util.List;

import koppen.jonas.ap.projectbig.ResistorCalc.Calculator;
import koppen.jonas.ap.projectbig.ResistorCalc.ICalculatorRepository;
import koppen.jonas.ap.projectbig.ResistorCalc.OhmLaw;
import koppen.jonas.ap.projectbig.ResistorCalc.ResistorCalc;
import koppen.jonas.ap.projectbig.ResistorCalc.resistor_parallel;
import koppen.jonas.ap.projectbig.ResistorCalc.resistor_serie;

/**
 * Created by Viktor on 13-12-2017.
 */

public class DummyRepository implements ICalculatorRepository {

    private static ICalculatorRepository repo = null;

    public static ICalculatorRepository getInstance() {
        if (repo == null) {
            repo = new DummyRepository() {

            };
        }
        return repo;
    }

    @Override
    public List<Calculator> getCalculator() {
        List<Calculator> calculators = new ArrayList<>();

        calculators.add(new Calculator("KleurCode", R.mipmap.ic_kleurcode, ResistorCalc.class));
        calculators.add(new Calculator("SerieSchakeling", R.mipmap.ic_serie, resistor_serie.class));
        calculators.add(new Calculator("ParallelSchakeling", R.mipmap.ic_serie, resistor_parallel.class));
        calculators.add(new Calculator("OhmsLaw",R.mipmap.ic_para,OhmLaw.class));//Dummy verander dit wannneer klasse beschikbaar is!!

        return calculators;
    }

    public static List<ActivityItem> getActivitys() {
        List<ActivityItem> calculators = new ArrayList<>();

        calculators.add(new ActivityItem("KleurCode", ResistorCalc.class));
        calculators.add(new ActivityItem("SerieSchakeling",  resistor_serie.class));
        calculators.add(new ActivityItem("ParallelSchakeling",  resistor_parallel.class));
        calculators.add(new ActivityItem("OhmsLaw", OhmLaw.class));//Dummy verander dit wannneer klasse beschikbaar is!!

        return calculators;
    }
}


