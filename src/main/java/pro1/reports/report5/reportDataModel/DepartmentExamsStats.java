package pro1.reports.report5.reportDataModel;

import java.util.List;

public class DepartmentExamsStats {
    public int realizedExamsCount;
    public List<Integer> teacherIds;

    public DepartmentExamsStats(int realizedExamsCount, List<Integer> teacherIds) {
        this.realizedExamsCount = realizedExamsCount;
        this.teacherIds = teacherIds;
    }
}
