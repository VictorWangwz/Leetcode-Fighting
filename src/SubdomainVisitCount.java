//811
public class SubdomainVisitCount {
//    public static List<String> subdomainVisits(String[] cpdomains) {
//        Map<String, Integer> m = new HashMap<>();
//        for(String s: cpdomains){
//            String[] parts = s.split(" ");
//            int num = Integer.parseInt(parts[0]);
//            String[] domainParts = parts[1].split(".");
//            StringBuffer tempDomain = new StringBuffer(domainParts[domainParts.length - 1]);
//            m.put(tempDomain.toString(), num + m.getOrDefault(tempDomain.toString(), 0));
//            for(int i = domainParts.length - 2; i >=0 ; i--){
//                tempDomain = new StringBuffer(domainParts[i]).append(".").append(tempDomain);
//                m.put(tempDomain.toString(), num + m.getOrDefault(tempDomain.toString(), 0));
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//        String[] cpdomains = {"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
//        List<String> rst = subdomainVisits(cpdomains);
//        System.out.println(rst);
//    }
}
