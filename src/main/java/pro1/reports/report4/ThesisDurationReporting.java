package pro1.reports.report4;

import com.google.gson.Gson;
import pro1.DataSource;
import pro1.apiDataModel.ThesesList;
import pro1.apiDataModel.Thesis;
import pro1.reports.report4.reportDataModel.ThesisDuration;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class ThesisDurationReporting {
    public static List<ThesisDuration> GetReport(DataSource dataSource, String katedra, String[] roky) {
        List<ThesisDuration> result = new ArrayList<>();
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("d.M.yyyy");

        for (String rok : roky) {
            String json = dataSource.getKvalifikacniPrace(rok, katedra);
            ThesesList list = new Gson().fromJson(json, ThesesList.class);

            long celkemDni = 0;
            int pocetPraci = 0;

            if (list != null && list.items != null) {
                for (Thesis t : list.items) {
                    if (t.datumZadani != null && t.datumZadani.value != null &&
                        t.datumOdevzdani != null && t.datumOdevzdani.value != null) {

                        try {
                            LocalDate start = LocalDate.parse(t.datumZadani.value, fmt);
                            LocalDate end = LocalDate.parse(t.datumOdevzdani.value, fmt);
                            long dny = ChronoUnit.DAYS.between(start, end);
                            celkemDni += dny;
                            pocetPraci++;
                        } catch (Exception e) {
                            // ignorujeme chyby pri parsovani
                        }
                    }
                }
            }

            long prumer = 0;
            if (pocetPraci > 0) {
                prumer = Math.round((double) celkemDni / pocetPraci);
            }
            result.add(new ThesisDuration(rok, prumer));
        }

        return result;
    }
}
