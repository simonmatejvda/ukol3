package pro1.reports.report5;

import com.google.gson.Gson;
import pro1.DataSource;
import pro1.apiDataModel.Termin;
import pro1.apiDataModel.TerminyList;
import pro1.reports.report5.reportDataModel.DepartmentExamsStats;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DepartmentExamsStatsReporting {
    public static DepartmentExamsStats GetReport(DataSource dataSource, String katedra) {
        String json = dataSource.getTerminyZkousek2(katedra);
        TerminyList list = new Gson().fromJson(json, TerminyList.class);

        int realizedExamsCount = 0;
        Set<Integer> teacherIdsSet = new HashSet<>();

        if (list != null && list.items != null) {
            for (Termin t : list.items) {
                if (t.obsazeni != null) {
                    try {
                        int obsazeniInt = Integer.parseInt(t.obsazeni);
                        if (obsazeniInt > 0) {
                            realizedExamsCount++;
                            teacherIdsSet.add(t.ucitIdno);
                        }
                    } catch (NumberFormatException e) {
                        // ignore
                    }
                }
            }
        }

        List<Integer> teacherIds = new ArrayList<>(teacherIdsSet);
        Collections.sort(teacherIds);

        return new DepartmentExamsStats(realizedExamsCount, teacherIds);
    }
}
