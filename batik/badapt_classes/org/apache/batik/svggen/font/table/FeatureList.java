package org.apache.batik.svggen.font.table;
public class FeatureList {
    private int featureCount;
    private org.apache.batik.svggen.font.table.FeatureRecord[] featureRecords;
    private org.apache.batik.svggen.font.table.Feature[] features;
    public FeatureList(java.io.RandomAccessFile raf, int offset) throws java.io.IOException {
        super(
          );
        raf.
          seek(
            offset);
        featureCount =
          raf.
            readUnsignedShort(
              );
        featureRecords =
          (new org.apache.batik.svggen.font.table.FeatureRecord[featureCount]);
        features =
          (new org.apache.batik.svggen.font.table.Feature[featureCount]);
        for (int i =
               0;
             i <
               featureCount;
             i++) {
            featureRecords[i] =
              new org.apache.batik.svggen.font.table.FeatureRecord(
                raf);
        }
        for (int i =
               0;
             i <
               featureCount;
             i++) {
            features[i] =
              new org.apache.batik.svggen.font.table.Feature(
                raf,
                offset +
                  featureRecords[i].
                  getOffset(
                    ));
        }
    }
    public org.apache.batik.svggen.font.table.Feature findFeature(org.apache.batik.svggen.font.table.LangSys langSys,
                                                                  java.lang.String tag) {
        if (tag.
              length(
                ) !=
              4) {
            return null;
        }
        int tagVal =
          tag.
          charAt(
            0) <<
          24 |
          tag.
          charAt(
            1) <<
          16 |
          tag.
          charAt(
            2) <<
          8 |
          tag.
          charAt(
            3);
        for (int i =
               0;
             i <
               featureCount;
             i++) {
            if (featureRecords[i].
                  getTag(
                    ) ==
                  tagVal) {
                if (langSys.
                      isFeatureIndexed(
                        i)) {
                    return features[i];
                }
            }
        }
        return null;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "NwRlD+m8FmzIjdYX+CMbLv4P2VzMjIQbAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL1ae+wsV12fe2/vo7e3vbcttKXS9y3SDv5mZ3dnHykgs8/Z" +
       "ncfu7HtH5TLv92PntbODVSAqRBIk2iIauH8VRSwFDUQTg6kxCgRCAiG+Eika" +
       "E1Ek0j9EIyqemf2976NtTNxkzp49c77nfF/nc77ne/b570GnAx+CPdfaqJYb" +
       "7shJuGNY2E648eRgp09hQ94PZKlp8UEwAW1XxEc/e/EHP/ywdukkdIaD7uYd" +
       "xw35UHedYCQHrhXLEgVdPGhtW7IdhNAlyuBjHolC3UIoPQifoqDbDpGG0GVq" +
       "jwUEsIAAFpCcBQQ/6AWIbpedyG5mFLwTBivo56ATFHTGEzP2QuiRo4N4vM/b" +
       "u8MMcwnACOey3zMgVE6c+NDD+7JvZb5G4Gdh5Jlff+el3z8FXeSgi7ozztgR" +
       "ARMhmISDLtiyLch+gEuSLHHQnY4sS2PZ13lLT3O+OeiuQFcdPox8eV9JWWPk" +
       "yX4+54HmLoiZbH4khq6/L56iy5a09+u0YvEqkPWeA1m3EnaydiDgeR0w5iu8" +
       "KO+R3GLqjhRCDx2n2JfxMgk6ANKzthxq7v5Utzg8aIDu2trO4h0VGYe+7qig" +
       "62k3ArOE0P03HDTTtceLJq/KV0LovuP9httXoNetuSIykhB6/fFu+UjASvcf" +
       "s9Ih+3yPeeuH3u0QzsmcZ0kWrYz/c4DowWNEI1mRfdkR5S3hhSepj/D3fOED" +
       "JyEIdH79sc7bPn/wsy+/4y0PvvilbZ8fu06fgWDIYnhFfE644+tvbD5RP5Wx" +
       "cc5zAz0z/hHJc/cf7r55KvHAyrtnf8Ts5c7eyxdHf758z6fk756EzvegM6Jr" +
       "RTbwoztF1/Z0S/a7siP7fChLPehW2ZGa+fsedBbUKd2Rt60DRQnksAfdYuVN" +
       "Z9z8N1CRAobIVHQW1HVHcffqHh9qeT3xIAg6Cx7oAngegLaf/DuEeERzbRnh" +
       "Rd7RHRcZ+m4mf4DITigA3WqIALzeRAI38oELIq6vIjzwA03eexGrquwgCtAN" +
       "EvKCJSMdOV8bGS7sZK7m/X9MkmSSXlqfOAGM8MbjEGCB1UO4liT7V8Rnokb7" +
       "5ReufOXk/pLY1VEI7YB5d7bz7uTz7mzn3cnm3cnn3Tk0L3TiRD7d67L5t/YG" +
       "1jLBugcvLzwx/pn+uz7w6CngaN76FqDqrCtyY2BuHiBFL8dDEbgr9OJH1++d" +
       "/XzhJHTyKMJmPIOm8xn5MMPFffy7fHxlXW/ci+//zg8+85Gn3YM1dgSyd5f+" +
       "tZTZ0n30uHZ9V5QloJOD4Z98mP/8lS88ffkkdAvAA4CBIQ98FsDLg8fnOLKE" +
       "n9qDw0yW00BgxfVt3spe7WHY+VDz3fVBS272O/L6nUDHt2U+fQ94Lu86ef6d" +
       "vb3by8rXbd0kM9oxKXK4fdvY+/hffe2fSrm695D54qG9biyHTx1Cg2ywi/m6" +
       "v/PABya+LIN+f/vR4a89+733/1TuAKDHY9eb8HJWNgEKABMCNf/il1Z//dK3" +
       "nvvmyQOnCcF2GAmWLib7Qmbt0PmbCAlme9MBPwBNLLDYMq+5PHVsV9IVPXPl" +
       "zEv/6+Lj6Of/5UOXtn5ggZY9N3rLKw9w0P6GBvSer7zz3x/MhzkhZrvZgc4O" +
       "um0h8u6DkXHf5zcZH8l7v/HAb3yR/zgAWwBwgZ7KOWadzHVwMpf89QB6c0rd" +
       "3RnxjuTauAiwIugA9AOjPnGTkMfXbWCueHebQJ6+6yXzY9/59HYLOL6nHOss" +
       "f+CZX/7RzoeeOXlo433smr3vMM1288397PatyX4EPifA8z/Zk5kqa9iC713N" +
       "3R3g4f0twPMSIM4jN2Mrn6Lzj595+o8++fT7t2LcdXTfaYOw6tN/8d9f3fno" +
       "t798HaA7BWKKnEMk5/DJvNzJ3G0XqXYVfveewnuDdiLKXmbEnO5tWfFQcBht" +
       "jqr9UJh3RfzwN79/++z7f/xyzsnROPHw4qJ5b6u3O7Li4UwN9x6HVoIPNNCv" +
       "/CLz05esF38IRuTAiLkjDHyA78mRpbjb+/TZv/mTP73nXV8/BZ3sQOctl5c6" +
       "fI5q0K0ATuRAA1tD4v3kO7araX0OFJeyWgLtKwbKFQMl21V4X/7rzM3drpOF" +
       "eQeYeN9/DizhfX//H9coIYfy63jiMXoOef5j9zff/t2c/gBTM+oHk2v3PBAS" +
       "H9AWP2X/28lHz/zZSegsB10Sd+PtGW9FGVJxIMYM9oJwEJMfeX80XtwGR0/t" +
       "7xlvPL4UDk17HM0PXBDUs95Z/fwxAL+wF5k8tIttDx0H8BNQXqFzkkfy8nJW" +
       "/PgeXp71fD0GKykfuRJCF5Ttlt10IyeHN2y7B2TlO7KC2Rq1eUMHII6yB4Pn" +
       "4V32Hr4Be9MbsJdV2T3O7tjlbCSLri8FwJ0ev7E75Vi5BaWrv/XY137+6mN/" +
       "l3v/OT0ASsd99TpR9SGa7z//0ne/cfsDL+Rb8i0CH2zVf/w4cu1p48ghIuf8" +
       "wlF1vOFm6thDksKrD6222vA8Dzpmp9lrtFPmOo/sMvbIDewkvBo7ndu1U5B3" +
       "447OcvfNZtkT/8lXL/51BBdfUfCc0eQE8P7TxZ3qTiH7bV9ftFNZ9c0grAjy" +
       "cy+gUHSHt/ZkvdewxMt7u9IMnIMBRF02rOqeJJdydM3AYGd7eDzGa+VV8wrc" +
       "/Y6DwSgXnEM/+A8f/uqvPPYS8Os+dDrO4Ac49aEZmSg7mv/S888+cNsz3/5g" +
       "HiUBW83e8/i/5ged5GYSZ8UqK/w9Ue/PRB3nRw6KD0I6D2xkaV/a4iF5aiEI" +
       "j9z/g7ThHc8T5aCH730olJOL62mSmIqDIWV1BOOyAjbYVstshRSr9/2x2h20" +
       "KiNLsDt6OJ4Ydj3iajoiFa16AYPhzXTYx1c8OdVZl2CZuI0wy9kYt80p2uHC" +
       "6WrlNvpsYapqoW3yjTicjKfWiEUFdiVITMw5XEzAYlpr18KSlMrVocIoA0Rh" +
       "YGbCoE2N5xsVN+yphDTod+Vkyo9qxUmD8qdUwxPcOaYPR+Iwrgp1OxJma4kt" +
       "jJu8LTZsozxiCvp00p8vB67hcczYmvfn/aivT7qDoUsvtb7R6DDcdK2MCMYJ" +
       "JtGKpGi7MCoHo5HRxI1Jc5V4LC8ao85YkFG8PUOXHG4mzWnfBwwKKmyIpjNJ" +
       "knQjj6ubVigKI88q1I2et1L9OGnSZYskN23Vp/o2OuwWdc7XLYMte111M2LU" +
       "NJrNuGWfcWcLjrNVmF+QRrGsjDujpF1Lm6uVN/K9CqZxOk+bfX05m3gpsVz1" +
       "u07EmrCOtPCVmHQmaGNVZNalhqcTS5QR5i5LeWRZ58cO5y4a6MpHx+a4sFZ1" +
       "b1XTYWO5blu+PSlHdCVhWb0kDSaMW8SM0czWOU+mNI7vtNJiMZYNU5mxFX1s" +
       "OSEH93s9fNyZsELDbbJcf8ljlLY0gmln6i/JFC6b2rIwlcM0kZY1r0Wulp5I" +
       "1cOOwXMF12nUS6OgsSi3S8vNdNSaGi5aERvYBF2lzajcJNhQEkazubFMZK6x" +
       "nvW4RmuodwfUYKmbSyucLoG3wIa7GfhcrYPbeDjRSL7Q6gsdXl32rSbTbLQ7" +
       "q8JAU1S1LrFar5lOe2xvoDcm5oIThHkwGdNaQW+P+PHQN+EavnK5UqNJa3wP" +
       "UwwSbjuap4p1iooRsUglNpIMVyNjjtfMlt3tt6d9p8bRzKJqUzw7aLV7WK+j" +
       "Ut0aRdS6qA+XqR4+aYultK1GXHVRNdDakKqIidhOxZ7HEytjULbavXrflAbL" +
       "qp6u5n6AOUtv4tq6mWKloIChzpyrot4EDtnl3E3JKrlgldiKxiVniCCF8aJX" +
       "V9ur6pTrmiRvmkmni3rNGTofE93GqjfGUXpcKSxTveH75QFcnU7aNa04n+mM" +
       "I8vM2gwbwYwkNqvxYICsp6Nk3iO5VWMsc5N5VBRrFU91YIcBag4Wa1ZerFfT" +
       "oW6U6hOtTfepqdWc0+TK7660ockYsBdoq5Y2CroFvdObu8S6ws2DFd7GEy+x" +
       "8B6brE19iOpcV++tyG450d2pobsm2p6VBb+1aRfHmhfXEMY008lcZrBo3mgn" +
       "AjYu482iwIymRaqtt3ViGgVVASsO4qbT1CvzNjcekKrfiKeDtYANgy4gaYQ2" +
       "zFaTsFBdxptarBWDugOvQ0T150RPLmlc7E+Q2rRQrRsLh620PHc9U3lT4Kt4" +
       "V22txHKxMa33vKK3Gmlx5FObOouvmiTNU0x7OtN02W8Num6n31+jy41VAKCi" +
       "bdo8wWqNHl1kMabXGkxobTSZk/qCb7aI5bA9TxfjeAnT0w3DscKQ56cEVqgO" +
       "Yp9ed2gf1w21wc6L3JiY0jVBTgoe5tnjEuzGjdkgnFf9UrHAmUaUzh2K0NhE" +
       "FQiqXbHZKo30hqmtT7XQULQAYxaSL6UBXWkE03XiNbR5UvJhwoNXhWIyFyuz" +
       "XrMZiGivbM7qwaooji2my6xcukYbIeciaZlfk13Gm+ORMtODGJ5I1XklSkW+" +
       "0hManDPUC2XW2VQWJUSzighSGQ3FUotfzqhVRSWwZhEtdIwmOl8Xwlk4GhTn" +
       "a7SpDqott4Qqw0ViVNOlHBRaIzqcd/15Gqh0r0OpbKogRNOP5Xjh2TWCaOkO" +
       "Tja9CsU2yWk69vvYrLViTL8ltE1RJns4ieLinOGLw5XWVEQrsYuiOK7U4ZmO" +
       "yjIixjCptYlmkC6XwqSWqkG5hgwXbkVRSsPKUPYx2glYvEh1OXbDr2A9cbDF" +
       "vKuK8pIYWA4VzupVtlTDI7yFdkcTQpdrKc6XW2xfrJVsvOMlE9TtC0HDn5hR" +
       "YJLdut1JRoGQdtSmJCsAT9mI6I2R1khnJbelTCJT4dF6nEhrZlEjG2a7hBUm" +
       "LrkGu9NiQ40K7T65RgMnsNjy1KuRzW7UJtfjUmwukZhSayhSXM4wrb3u8bzh" +
       "BkrXp/H+OPIKxMaTmILVKXdYP/R9tYwoMNpxl7iyJkptjoE1qlQTS0S9F3W4" +
       "wmCMcsaSF0YltsJqhWLYGnr2ShC0BVNAFIKuarBcpNDFuLMwEjkZ8G1LQegZ" +
       "UlJdGVEWHXKK64vqsoKyEud3xRVc3MRCedQ0ShuvZooEH5NVl9QKLkZOyahO" +
       "mnJlKRdmbiFIpuhgGnilWG8XqzO7S+MS4+ONUlLpjCRjxC3Xs8hgAnMQR1Ux" +
       "pUZdSZsMnWJt3E14vlp1fKky8Ee9OtnYpKLfsCuw5EbCOozNqBbSrTrfISo+" +
       "F/Qm2JIvK51U0sGiKrSwqoB09JkYlYt+S+2RCDmttKa4wwxk1x6NOomAVHQ5" +
       "RmGs3E9qnchqem7UWXZgASXEIr42fboxaFTmMUKvK2Rk9AV8Ss/lgq4ZXZpl" +
       "1Hqfa282pW6Fj7oe2neUXo1AELjUUeZEHy6v1UikQm65GTrpnI81fDGCZwS7" +
       "xkBQ0EJKNZhiiJE5X044ujD0MQyBvRkItWG4VgvMEt1zxuRQGW5a7mw4pGBt" +
       "KWOldIAa3agTT4pyYVTH6UF1TTtmqTZkGkqd6TXJBtqdcY0S0/Cb46WqglBD" +
       "HBXSSrxWCKZWx6pho1GXiKC7ShSsXbdRf1TvlBQQdLWKWBlvOJFUajOWvixE" +
       "OJEaaZuocqkVx+UizXfhYlEkwyXTXVbjBJemnEQHY6uDLagxTsw8EpOMlGQJ" +
       "VhgkGltgAxQT076BOCiAaKWxCqsjL600G7SY1ASR4teRoHq2bfaj8qxna+00" +
       "Xohqd9TS3CZHojZjYaV6oMT0kCpHS4dd6QopR+2aRHk4PMZSqx1M0YWMzYUh" +
       "hm56dFUvdRzNtH19vkHjYboY1bRQpk3PbBd7xLq7IcXKmMJg3lvVxXgmjSVM" +
       "QyVcZNqr2qjSglscVoyHAef4M9rsUnN0gWqzkgLgTgollFAcihlGWE8uUI7I" +
       "1jW1QqW6QEVmAWN1sS6AoKi84t0EdyUzpb2SizoTQUz68GI4KXIB6gglBqxR" +
       "vowyy01xgQbBxo0HSC9iq3g1FqakXOklvCQJdkQuVIEWHKfQHgf1ukYOkMli" +
       "WsPNiVBXemOmLY5LHdilKy20VajhWrqKKgS9RuCqKocsHMeY1CKwyI9FMjHi" +
       "JFAnkrfhMEuxWkoRIZwG6s/7hCKtFTtez0UbwSipOrFKYtBmK91BszTFe4PA" +
       "rsRxOw0XGu4yrNbWIhD3o+5GsRcjfeBrQZ3aVAoeMm6tRuV11E9p0+xUonij" +
       "UGi9JE5Qu4uvkXJSKPJeWS0Q65quRkTVWGulYnU+KJGDtMTUtbVKU5oZz6OZ" +
       "JcgyWsZ0ZRg4ok/XO4WJnRhsYdNkKynfrs+oNIgwOVkUNYlY6YE9iRJyGOsz" +
       "LyjBNghHJ91p2ddHDvAirBOZlEFTMzwKOoizqIku71dSVGNnNbsWIauJOsQ7" +
       "4YYYi53GfE2lCiVtdN4u053Ud/T1FEW6Whp4a2kEU7JQ9YOpNfEKQX9UFvuD" +
       "Gu6KTK/bHXLI1HNNqTAfmDWhTpADwhk4XBqsHDp0Yh+n6n64aFf6K4TvSV1O" +
       "L8BLR3BKG5vSPLPB1oYBNidZwElflO2Fz1oEjcqVom5MwzgtgZjJJquitaRU" +
       "rhAsZJVE1l3XbbmUv57Dy6rB2YbNxCmMYf5cqY6jSgMvNRlvTICTQkoJwWIi" +
       "Bx5JTwBOWgTD6xJCVFRFdhZJfRkZCILi9Wo4r8yq03m1ohMTDB4MY8Jbl+YA" +
       "WTip6LaH5MQj7AlC68tmqCJLdaM3Q3Ae6g16QW9Fd8QaJjYFqkEnK5ySKU6s" +
       "kGlzU/XKfTVNy02ujkRr0XKthuG7Y5mZz9GBPRkaMAvji1l/EkWYIXY5MZ7W" +
       "Ft26P0kbAWtgnbVRqQrMemS1YLvWsdOeIS0XcJMWqLg8LM5S2uixAjid5vnd" +
       "X3htx+k788zB/h00OEVnL8LXcGLePb9nxeP7SZb8cwY6dm95+LbjICMLZTnj" +
       "B250tZynzZ973zNXpcEn0Cx5kBHWQ+jW0PV+wpJj2To0VJaeePLG2Tg6T4od" +
       "ZFi/+L5/vn/ydu1dr+Gi7qFjfB4f8nfo57/cfZP4qyehU/v51mvu/I8SPXU0" +
       "y3rel8PIdyZHcq0P7Gs2y1xBD4IH3dUsejx9dWC762fI3ry1/bFLhGO3Nq8m" +
       "90Xxjjre5BTbi4nfPDbmXv49+301K54NoduU7BpkmzXLmvQDL/vIK+VljuT0" +
       "wVCHrnWzO6r7rvkTyfaPD+ILVy+eu/fq9C+3adS9PyfcSkHnlMiyDme4D9XP" +
       "eD6IXHPeb93mu7386xMh9OgrKyeETuffOd/PbSk/GUJvvBllCN2SfR0m+d0Q" +
       "uvcGJFkyMK8c7v9CCF063h+wkn8f7vd7IXT+oB8Yals53OVzIXQKdMmqn/eu" +
       "k0jc3iokJ46u5H1j3vVKxjy0+B87smTzfwztLa9o+5+hK+JnrvaZd79c+cT2" +
       "lle0+DTNRjlHQWe3F877S/SRG462N9YZ4okf3vHZWx/fg5M7tgwfLJxDvD10" +
       "/SvVtu2F+SVo+of3fu6tv331W3le838Bh8l0lMolAAA=");
}
