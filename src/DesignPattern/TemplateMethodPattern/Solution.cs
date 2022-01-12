  public class TransferMoneyTask : Task
        {
            public TransferMoneyTask(AuditLog auditLog) : base(auditLog) { }

            protected override void DoExecute()
            {
                throw new System.NotImplementedException();
            }
        }
        public class GenerateReportTask : Task
        {
            public GenerateReportTask(AuditLog auditLog) : base(auditLog) { }

            protected override void DoExecute()
            {
                throw new System.NotImplementedException();
            }
        }

        public abstract class Task
        {
            private AuditLog auditLog;

            public Task(AuditLog auditLog)
            {
                this.auditLog = auditLog;
            }
            public void Execute()
            {
                this.auditLog.Record();
                this.DoExecute();
            }
            protected abstract void DoExecute();

        }
        public class AuditLog
        {
            public void Record()
            {

            }
        }
