/**
Problem:
- Code duplication
- No code structure
**/
public class TransferMoneyTask
{
    private AuditLog auditLog;

    public TransferMoneyTask(AuditLog auditLog)
    {
        this.auditLog = auditLog;
    }

    public void Execute()
    {
        this.auditLog.Record();
        //Transfer funds
    }
}
public class GenerateReportTask
{
    private AuditLog auditLog;

    public GenerateReportTask(AuditLog auditLog)
    {
        this.auditLog = auditLog;
    }

    public void Execute()
    {
        this.auditLog.Record();
        //Generate Report
    }
}
public class AuditLog
{
    public void Record()
    {
        //Log data
    }
}
