
public class Day1 {

    public static void main(String[] args) {
        String input = "1865\n" +
                "1179\n" +
                "1328\n" +
                "1390\n" +
                "322\n" +
                "1999\n" +
                "1713\n" +
                "1808\n" +
                "1380\n" +
                "1727\n" +
                "1702\n" +
                "1304\n" +
                "1481\n" +
                "1334\n" +
                "1728\n" +
                "1953\n" +
                "1413\n" +
                "1753\n" +
                "1723\n" +
                "1379\n" +
                "1532\n" +
                "1918\n" +
                "1490\n" +
                "71\n" +
                "1388\n" +
                "1519\n" +
                "807\n" +
                "1427\n" +
                "1729\n" +
                "1952\n" +
                "970\n" +
                "1405\n" +
                "1500\n" +
                "1782\n" +
                "1899\n" +
                "1501\n" +
                "1720\n" +
                "1832\n" +
                "1706\n" +
                "1658\n" +
                "1333\n" +
                "486\n" +
                "1670\n" +
                "1674\n" +
                "1290\n" +
                "1893\n" +
                "1382\n" +
                "1761\n" +
                "1945\n" +
                "1607\n" +
                "1319\n" +
                "1508\n" +
                "1464\n" +
                "1733\n" +
                "1917\n" +
                "1483\n" +
                "1620\n" +
                "1677\n" +
                "1835\n" +
                "1810\n" +
                "1385\n" +
                "1840\n" +
                "1705\n" +
                "1994\n" +
                "1695\n" +
                "1599\n" +
                "1681\n" +
                "1566\n" +
                "1153\n" +
                "1672\n" +
                "1373\n" +
                "1679\n" +
                "1714\n" +
                "1283\n" +
                "1950\n" +
                "1197\n" +
                "1696\n" +
                "1936\n" +
                "1218\n" +
                "1910\n" +
                "1786\n" +
                "958\n" +
                "1565\n" +
                "1583\n" +
                "1914\n" +
                "1853\n" +
                "1682\n" +
                "1267\n" +
                "1543\n" +
                "1322\n" +
                "1965\n" +
                "1406\n" +
                "860\n" +
                "1754\n" +
                "1867\n" +
                "1393\n" +
                "1404\n" +
                "1191\n" +
                "1861\n" +
                "2007\n" +
                "1613\n" +
                "1938\n" +
                "1340\n" +
                "1227\n" +
                "1628\n" +
                "1826\n" +
                "1638\n" +
                "1970\n" +
                "1993\n" +
                "1748\n" +
                "496\n" +
                "1661\n" +
                "1736\n" +
                "1593\n" +
                "1298\n" +
                "1882\n" +
                "1763\n" +
                "1616\n" +
                "1848\n" +
                "92\n" +
                "1338\n" +
                "1707\n" +
                "1587\n" +
                "1996\n" +
                "1708\n" +
                "700\n" +
                "1460\n" +
                "1673\n" +
                "1450\n" +
                "1815\n" +
                "1537\n" +
                "1825\n" +
                "1683\n" +
                "1743\n" +
                "1949\n" +
                "1933\n" +
                "1289\n" +
                "1905\n" +
                "1307\n" +
                "1845\n" +
                "1855\n" +
                "1955\n" +
                "1554\n" +
                "1570\n" +
                "1931\n" +
                "1780\n" +
                "1929\n" +
                "1980\n" +
                "1978\n" +
                "1998\n" +
                "1371\n" +
                "1981\n" +
                "1817\n" +
                "1722\n" +
                "1545\n" +
                "1561\n" +
                "1352\n" +
                "1935\n" +
                "1553\n" +
                "1796\n" +
                "1847\n" +
                "1640\n" +
                "1414\n" +
                "1198\n" +
                "1669\n" +
                "1909\n" +
                "1879\n" +
                "1744\n" +
                "1783\n" +
                "1367\n" +
                "1632\n" +
                "1990\n" +
                "1937\n" +
                "1919\n" +
                "1431\n" +
                "2002\n" +
                "1603\n" +
                "1948\n" +
                "1317\n" +
                "1282\n" +
                "1349\n" +
                "1839\n" +
                "1575\n" +
                "1730\n" +
                "1849\n" +
                "1959\n" +
                "1971\n" +
                "2009\n" +
                "1641\n" +
                "1402\n" +
                "1924\n" +
                "1757\n" +
                "1605\n" +
                "1693\n" +
                "1762\n" +
                "283\n" +
                "1525\n" +
                "1964\n" +
                "1715\n" +
                "1602";


        System.out.println("part 1:");
        part1(input);
        System.out.println("part 2:");
        part2(input);


    }

    private static void part1(String input) {
        String[] list = input.split("\\s");
        for (int y = 0; y < list.length; y++) {
            for (int i = 0; i < list.length; i++) {
                if (y == i) {
                    continue;
                }
                if (Integer.parseInt(list[y]) + Integer.parseInt(list[i]) == 2020) {
                    System.out.println("Answer found");
                    System.out.println("Answer = " + Integer.parseInt(list[y]) * Integer.parseInt(list[i]));
                    return;
                }

            }
        }
    }

    private static void part2(String input) {
        String[] list = input.split("\\s");
        for (int y = 0; y < list.length; y++) {
            for (int i = 0; i < list.length; i++) {
                for (int j = 0; j < list.length; j++) {

                    if (Integer.parseInt(list[y]) + Integer.parseInt(list[i]) + Integer.parseInt(list[j]) == 2020) {
                        System.out.println("Answer found");
                        System.out.println("Answer = " + Integer.parseInt(list[y]) * Integer.parseInt(list[i]) * Integer.parseInt(list[j]));
                        return;
                    }

                }
            }
        }
    }


}
