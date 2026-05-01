package pro1.reports.report2.reportDataModel;

public class DepartmentStats
{
    public long maxActionStudentsCount;
    public long emptyActionsCount;
    public long maxTeacherScore;

    public DepartmentStats(long maxActionStudentsCount, long emptyActionsCount, long maxTeacherScore) {
        this.maxActionStudentsCount = maxActionStudentsCount;
        this.emptyActionsCount = emptyActionsCount;
        this.maxTeacherScore = maxTeacherScore;
    }
}
