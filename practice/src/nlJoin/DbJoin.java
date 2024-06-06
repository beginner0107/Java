package nlJoin;

import java.util.Date;
import java.util.List;

public class DbJoin {

    public static void aQuery(List<PRA_HST_STC> a, List<ODM_TRMS> b, long saleOrgId) {
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i).saleOrgId == saleOrgId) {
                for (int j = 0; j < b.size(); j++) {
                    if (a.get(i).strdGrpId == b.get(j).strdGrpId && a.get(i).strdId == b.get(j).strdId) {
                        System.out.println("return row");
                    }
                }
            }
        }
    }

    public static void bQuery(List<PRA_HST_STC> a, List<ODM_TRMS> b, long saleOrgId) {
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i).saleOrgId == saleOrgId) {
                for (int j = 0; j < b.size(); j++) {
                    if (b.get(j).strdGrpId == a.get(i).strdGrpId && b.get(j).strdId == a.get(i).strdId) {
                        System.out.println("return row");
                    }
                }
            }
        }
    }

    public static class PRA_HST_STC {
        public long saleOrgId;
        public long strdGrpId;
        public long strdId;
        public Date stcDt;

        public PRA_HST_STC(long saleOrgId, long strdGrpId, long strdId, Date stcDt) {
            this.saleOrgId = saleOrgId;
            this.strdGrpId = strdGrpId;
            this.strdId = strdId;
            this.stcDt = stcDt;
        }
    }

    public static class ODM_TRMS {
        public long strdGrpId;
        public long strdId;

        public ODM_TRMS(long strdGrpId, long strdId) {
            this.strdGrpId = strdGrpId;
            this.strdId = strdId;
        }
    }
}
