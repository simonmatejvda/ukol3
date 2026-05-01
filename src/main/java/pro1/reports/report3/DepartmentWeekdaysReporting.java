package pro1.reports.report3;

import com.google.gson.Gson;
import pro1.DataSource;
import pro1.apiDataModel.ActionsList;
import pro1.apiDataModel.Action;
import pro1.reports.report3.reportDataModel.WeekdayStats;

import java.util.ArrayList;
import java.util.List;

public class DepartmentWeekdaysReporting {

    public static List<WeekdayStats> GetReport(DataSource dataSource, String rok, String katedra, String[] dny) {
        // 1. Získání JSONu z API
        String json = dataSource.getRozvrhByKatedra(rok, katedra);

        // 2. Převod JSONu na objekty
        ActionsList actionsList = new Gson().fromJson(json, ActionsList.class);

        List<WeekdayStats> reportItems = new ArrayList<>();

        // 3. Projdeme všechny požadované dny (např. "Po", "Út", "St")
        for (int i = 0; i < dny.length; i++) {
            String hledanyDen = dny[i];
            int pocetAkci = 0;

            // Ošetření, aby to nespadlo, pokud je seznam akcí prázdný (ochrana proti NullPointerException)
            if (actionsList != null && actionsList.items != null) {
                // Projdeme všechny akce v rozvrhu
                for (Action akce : actionsList.items) {
                    // Porovnáváme Stringy přes .equals() a hlídáme, aby akce.day nebyl null
                    if (akce.day != null && akce.day.equals(hledanyDen)) {
                        pocetAkci++;
                    }
                }
            }

            // Přidáme výsledek pro daný den do reportu
            reportItems.add(new WeekdayStats(hledanyDen, pocetAkci));
        }

        return reportItems;
    }
}