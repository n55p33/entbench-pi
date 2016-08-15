package org.apache.batik.svggen.font.table;
public class GlyfTable implements org.apache.batik.svggen.font.table.Table {
    private byte[] buf = null;
    private org.apache.batik.svggen.font.table.GlyfDescript[] descript;
    protected GlyfTable(org.apache.batik.svggen.font.table.DirectoryEntry de,
                        java.io.RandomAccessFile raf) throws java.io.IOException {
        super(
          );
        raf.
          seek(
            de.
              getOffset(
                ));
        buf =
          (new byte[de.
                      getLength(
                        )]);
        raf.
          read(
            buf);
    }
    public void init(int numGlyphs, org.apache.batik.svggen.font.table.LocaTable loca) {
        if (buf ==
              null) {
            return;
        }
        descript =
          (new org.apache.batik.svggen.font.table.GlyfDescript[numGlyphs]);
        java.io.ByteArrayInputStream bais =
          new java.io.ByteArrayInputStream(
          buf);
        for (int i =
               0;
             i <
               numGlyphs;
             i++) {
            int len =
              loca.
              getOffset(
                i +
                  1) -
              loca.
              getOffset(
                i);
            if (len >
                  0) {
                bais.
                  reset(
                    );
                bais.
                  skip(
                    loca.
                      getOffset(
                        i));
                short numberOfContours =
                  (short)
                    (bais.
                       read(
                         ) <<
                       8 |
                       bais.
                       read(
                         ));
                if (numberOfContours >=
                      0) {
                    descript[i] =
                      new org.apache.batik.svggen.font.table.GlyfSimpleDescript(
                        this,
                        numberOfContours,
                        bais);
                }
                else {
                    descript[i] =
                      new org.apache.batik.svggen.font.table.GlyfCompositeDescript(
                        this,
                        bais);
                }
            }
        }
        buf =
          null;
        for (int i =
               0;
             i <
               numGlyphs;
             i++) {
            if (descript[i] ==
                  null)
                continue;
            descript[i].
              resolve(
                );
        }
    }
    public org.apache.batik.svggen.font.table.GlyfDescript getDescription(int i) {
        return descript[i];
    }
    public int getType() { return glyf; }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "Azl9hyt/HwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL16e8zk1nUf91utdiVL2pVsS6qqt9ZO7XE/Dofz4GDT1PPi" +
       "cDgkZ4YccobTNGsO38P3a8ihqyY2ktqtAcdo5MRFE/3ltHkothEkaIHGhYKg" +
       "jY2kKRKkaVO0URr0kdY1YP/RtKjTppec770PSU3aAXh5h/ece+4595zfPby8" +
       "b3wTuhKFUMX37J1ue/GhmsWHG7txGO98NTokqcZUCiNV6dlSFM3Bs9vyy1+5" +
       "/kff+Zxx4wB6cAW9V3JdL5Zi03MjVo08e6sqFHT99OnAVp0ohm5QG2krwUls" +
       "2jBlRvEtCnrPGdYYukkdDwEGQ4DBEOByCHDnlAowPaq6idMrOCQ3jgLor0OX" +
       "KOhBXy6GF0Mvne/El0LJOepmWmoAerhW/BeAUiVzFkIvnui+1/kOhT9fgV/7" +
       "se+78fOXoesr6LrpcsVwZDCIGAhZQY84qrNWw6ijKKqygh53VVXh1NCUbDMv" +
       "x72CnohM3ZXiJFRPjFQ8THw1LGWeWu4RudAtTOTYC0/U00zVVo7/XdFsSQe6" +
       "Pnmq615DvHgOFHzYBAMLNUlWj1kesExXiaEXLnKc6HhzDAgA61VHjQ3vRNQD" +
       "rgQeQE/s586WXB3m4tB0dUB6xUuAlBh65p6dFrb2JdmSdPV2DD19kW66bwJU" +
       "D5WGKFhi6P0XycqewCw9c2GWzszPN5nv/uzHXcI9KMesqLJdjP8aYHr+AhOr" +
       "amqourK6Z3zkw9SPSk9+9dMHEASI33+BeE/zD/7atz/6keff/Nqe5s/fhWay" +
       "3qhyfFv+4vqx33y296H25WIY13wvMovJP6d56f7To5ZbmQ8i78mTHovGw+PG" +
       "N9l/Kv7Az6jfOIAeHkEPyp6dOMCPHpc9xzdtNRyqrhpKsaqMoIdUV+mV7SPo" +
       "KqhTpqvun040LVLjEfSAXT560Cv/AxNpoIvCRFdB3XQ177juS7FR1jMfgqCr" +
       "4IK+C1zPQftfeY+h27DhOSosyZJruh48Db1C/whW3XgNbGvAa+D1Fhx5SQhc" +
       "EPZCHZaAHxjqccNW11UX1oBt4Fha2yo8tHfavKgdFo7m/78XkRVa3kgvXQIT" +
       "8OzF8LdB5BCerajhbfm1pDv49pdu/9rBSTgc2SeGPgKkHu6lHpZSD/dSDwup" +
       "h6XUwxOp0KVLpbD3FdL3Mw3myQIRD7DwkQ9xf5X82KdfvgxczE8fAEYuSOF7" +
       "Q3LvFCNGJRLKwFGhN7+QfkL4/uoBdHAeW4sRg0cPF+zTAhFPkO/mxZi6W7/X" +
       "P/WHf/TlH33VO42uc2B9FPR3chZB+/JF24aerCoABk+7//CL0i/e/uqrNw+g" +
       "BwASAPSLJeCtAFievyjjXPDeOgbCQpcrQGHNCx3JLpqO0evh2Ai99PRJOemP" +
       "lfXHgY0fK7z5KXC9fOTe5b1ofa9flO/bO0kxaRe0KIH2L3H+T/yr3/jPaGnu" +
       "Y0y+fmaV49T41hkcKDq7Xkb846c+MA9VFdD92y9Mf+Tz3/zUXykdAFC8cjeB" +
       "N4uyB+IfTCEw8w99Lfjdt37vi799cOo0MfSQH3oxiBRVyU70LJqgR++jJxD4" +
       "wdMhASixQQ+F49zkXcdTTM0sPLhw1D++/gHkF//rZ2/sXcEGT4496SNv38Hp" +
       "8z/XhX7g177vvz9fdnNJLpayU7Odku3x8b2nPXfCUNoV48g+8VvP/Z1flX4C" +
       "IC1At8jM1RKwDkozHJSavz+GkHcQoH0zVAun3Q3cONwdcz5dyjS9Q1ZyFc/p" +
       "yABkIhyAZukScEn24bI8LOx+FLJHzO89Zh5NBpms+oUqJV+jKF6Izobd+cg+" +
       "k+nclj/32996VPjWP/52aaTzqdJZL6Ml/9besYvixQx0/9RFjCGkyAB09TeZ" +
       "771hv/kd0OMK9FgqNQkBzGXnfPKI+srVf/3Lv/Lkx37zMnSAQw/bnqTgUhne" +
       "0EMgrtTIAAiZ+X/5o3ufSq+B4kZRy6ATw0ClYaBs74tPl/+KZPND90Y2vMh0" +
       "TsHh6f85sdef/IP/cYcRSky7ywJ/gX8Fv/Hjz/S+5xsl/ym4FNzPZ3dCP8gK" +
       "T3lrP+P8t4OXH/wnB9DVFXRDPko5BclOipBdgTQrOs5DQVp6rv18yrTPD26d" +
       "gOezF4HtjNiLsHa65IB6QV3UH76AZI8UVn4eXC8cRfgLF5HsElRWBiXLS2V5" +
       "syi+6xg4rvqhuQX5xBFs/An4XQLX/y6uorPiwX71f6J3lIK8eJKD+GA1vLxO" +
       "NDC1H7j31JbRu8+pXv97r/zG97/+yr8rPfGaGQEDdEL9LkneGZ5vvfHWN37r" +
       "0ee+VK4TD6ylaG+Ki9nxncnvuZy2tNwjJ5Z7ttDpRWCBX9obbn+PIflPmX+s" +
       "Q1PRVbgLRsnJoQkwwNUH7tYMPdcBfRynOf8/xGT3D7hpaDpgfdoeZcTwq0+8" +
       "Zf34H/7cPtu9GF0XiNVPv/a3/uTws68dnHnHeOWONP8sz/49o5yER4uCLEb3" +
       "0v2klBz4f/ryq//op1791H5UT5zPmAfghfDnfud//frhF37/63dJ0x5Y72L1" +
       "rlj90aKYHsfG9949Ng5i8HaZrG0TLFNXNNOV7HL0JHhsq64eGyUDd6RMcVuA" +
       "YABOWFQnfnYi+cLitF8lCnwAbzKeqxar0XHb+45XkJO3SNCY3aFDCH343vNK" +
       "l05/ima/+sn/8sz8e4yPvYvs8IUL83Kxy5+m3/j68IPy3z6ALp9g2x2vmOeZ" +
       "bp1HtIdDFbwTu/NzuPbcflpK+90Dr4rq7f08XFiLj5ec4n94n7ZyesC72RW5" +
       "MP5+ru5DnmbQPhksSqwo8P183LrnAvjR8/B8cw80EHR8vws85/dRd3TsdtcU" +
       "NSpjvSSjz0t5+n5Sjt0LfocvLv0jQb7vX9T+42+r/T4gLoGl5UrtsHVYLf7/" +
       "0N31u1xOJwioqNxXKf597Fjbpza2fPN4xRHUMAIue3Njt451uXEaRvudiQsD" +
       "Jd/xQEE4PXbaGeW5+q3P/PvP/foPv/IWABUSurItFnYQFWckMkmx7/M33vj8" +
       "c+957fc/UybiYLaEH/zOM2WvP3w/dYvib55T9ZlCVa6EekqKYrpMnFXlRNsL" +
       "GPMAcNz/e23j639M1KNR5/hHISu10eEz1t3W0Hi3rreW5rLfkRfdDtrlNU6w" +
       "XZPoy+lqiCeV8YzTG4azQmOUrYkuaztqAtdomiVIERdJnp9Z0rwK69bQJwyR" +
       "tCXONLxonNfHosVX6YXnk4FIS0E28hckh62W22ajtVLVtM8NxzXJ9Vtqq7lN" +
       "Wm0CbrW2zRxtTgOnNmfILsOuHDGVkDSsSsMGS5u7VVOgnR0S4eKcam75bbj2" +
       "XSZc6ybrOATnklKErEmrOm/igW6HDp3xzCgmHWsXM6uZYw2nM78rIuyOc5qM" +
       "lzoSKcKs3RcWHB4q4hzvuAuuJvFzcibSDaFux3hFTcnhyloZZDasWNiGq0+2" +
       "yXjo8MpiSpMLGLWmSh01u3Zmo5QYzJDE4iWLI1d+YLLBcJy1/IwMN2xV4XZ2" +
       "08xoebfD2DWqCtEwaE55fJwYWDJZ9jewZC1a1pi0HMnf0IkbLhaL0GvODIat" +
       "JuNJO/CqYq26QXecwCuUPlpI1rjiRUMPx0etnjdqIlR3HW8926tVm0wur/Sc" +
       "r1eNel0UHXWiZWSXHi+YKY1t0H5/ytNCXMv1nMujBjVuzqLBlFDHu2mrFW/5" +
       "iqXbEms5lOjVDCZhRZamccMaGgpJu2S4qFpcj/TWJNup0VOeZVhhLLTWkl3b" +
       "pbbPW1GvskKR0bi/ECeSNkCWQq1LWDRK76wUxSojO+Gnq20zmAf+rLeQ1Gak" +
       "e2QF7cjdcbYUh4zD62M4QpwgNn1J9/HVTGxiGxzRujNSD2VkZsfrnEMEf6Dv" +
       "ZkwyMIOAs0fWVFdtb8yNY0Qe9OaWatlkVVCGjTEm8CE7JHxLHzZm28446Akp" +
       "u6Opkd3rrNzUiZg+opNiu43a7bxeaazjlSCZ+LzjGgwvuATcl/v8YNGVuMaU" +
       "94nOpDucbtLEqEhquEmq40FnOuQ71FCvqBaax5VqMJlaUZ1yMHNU7cCDWBiK" +
       "WWXRwyoiv5rO4iSg2RjpOk1f6mfaisr5fOVtK+5kKHZSHqbzepSkGExZtUCF" +
       "tW3EVuzmCJmq86FtL6PMTb26s3M3A95eeWEwWDGmgg+mDbsT87Op1m5PpWCg" +
       "CfNZwOoqx4nJTrPHNhYMJFfDhjgnGD2bZafaTKAkq6XxjCkprelQ5GYLdzPC" +
       "tT5NTqj+NnNIViGbhiVaC2XEz0WMdjbheF3lO7I61mvozOrbTZhZUP6CZWR6" +
       "PF4Hoj7Q/J6TewkrjPzAkrhJr7fEBdZfeWLdRmqD7WbUcLRpA7z79cecRAv4" +
       "otcZysQmxChyITlhbxEOGwS6Wq1Rd4Mpk56i9eq1fmg0cDwa+mLYDZ2gvsYD" +
       "B5cZOVv2VWVJsrygUQSZUEHKMIY/bmR1ncmHXZ5eCzVURQSLpBwgzBty1no+" +
       "x1G/ucSNNOqnjlszwtqm5W5kYWrwhmBTLElH8XgMBu8vxDE9CFXJgDfZRh+Q" +
       "c7mWT9eDrp4FvtmadwfdecAaRo6M3Q3SmWeZs2qRbtcUsjprTux6dc3Cq8m8" +
       "W11vFwS8RrgBh3lyf0mNJKuTr7oZMcBqfQUXua64ndRa/Ryti257gs6WAyLP" +
       "splDdVepN6tpM0KkAlO2qFU1mWZGS6vKS2GqDzpO1U5TgOiTOhlWpj2nhuGJ" +
       "PeYn3UErALgF8HaxqaPBgtkKrFKft5r8XHXTLKmKKSF3PczVJLLBwHUlCLqt" +
       "+dxAKobb4ez6errZWVOi02q04QYSJGtTpWNiY8JZ10bZlpdGrjQZGIzCIDWX" +
       "t/wqhVTEaU9V27CWiESLwvs0tV7peEtsd3Bbn9n9PG7ASjsKV0zarOAE1XbJ" +
       "AWkEVj5h0qolbylTao/4zGqIMtFo+WIHFjixw9bcZk1kljhLAit72DBro31y" +
       "i0kMXFOqwXIwxAeyOsdtpN4BDh45S6ttT9ZwTHT9pjOjtaApuVOyO2ansqOo" +
       "kh9yw0l9o2DqylHaMOt6HV2nO1EgRH6WbWZIyoy4RmOym1BUSs5tM3JYSVb0" +
       "FhNuNo7cWmYMO6ts7TU3cG0r6OwakiaCiestkkaNXWKwCJA4YejNOidHakNr" +
       "dlASofusimOosqGjVk7kbmU3le3VnGnlVV1hmnm7Xt9kS2tTaWFouJIi18M9" +
       "AOJaKs/7WNwbRSHJRcDWwNkJhgrQcDdqGNlwuLZmek3U6bThVmEJYRZImLca" +
       "CDNnKITj+G7FF1Der3JaVq9WnZRyTMHwO9OFgjW4tcE3GaRKsSZV1Xamics0" +
       "xy7pUbfmCktZRL28m9A1FKzI0rzSwJR+fdjewf05QTTWUnckt+oYmS97vaZF" +
       "EG7GtbB2m0Lb3o6iFnhHYlMGa2mYxE8YFN4OtS4Xuj3cszppmPar6gTdVNor" +
       "zG65TAWnk3myM5ZDVtcJKsEQNifhPrpcwD1/IHkKGdRytzGJbEaMOvQsawQT" +
       "3mr6PbTSbrXkasDOiKXrLf3hYCC2d+mqi4xQsjpQglZfxmWKZueK3s136Xpe" +
       "E3F5PelhdL2zajm9OE2yRA66gRD2hXE38dLhTDL1fMxNBGyRc8sqa8bdfJyZ" +
       "6FDncbAgytXpFKGadWU73ZERijiDCdmrEZsGT7YqC1Xzp3oy3I30XW8dhcaO" +
       "QcNlu7FzEqZNcGK3maW4yo8wspOoIjMBCyY2NDf02iDatNlTK8MVAe/aabQ2" +
       "AxIfVSO9UqV3ktgTxxOQD/NspnBIf+Sbfr0Pb2r8TE0kYepE6rCOwtKklcd1" +
       "dArPaMLbhHjHwwZblve5PMWILG1X2s2V77uEuvJnhhqgglrZNtKQYgRMyAKU" +
       "0yMkzc0wIbyJY3lD4CPjVpYv+k5FUJbiVJ6u+lsJG1suNnQ7fmOK8fi87nVS" +
       "SUimS2FN57EsmHjb1jkzlYYsUWs7cbuBAThMd2bf64qhH6JITTOW2nZQxVf4" +
       "WMl7Fb9P1TGPHy0I0ZgSqFz14zR0m9NtbrI1eEJlG79tCE4L5pvxYucsJnCl" +
       "wlYrdG+dZ0sSpI2mWE8X7CAbhVq6GHRHMVxrUSK6lcbbbQfZ1iwqiPxaa1yd" +
       "VkAGgHjhEJblGaUFCkdQtl6N0+oGn5nqqDtgalu0QwxbXA2fqfGgRyPsRkrG" +
       "fi8WerIwF6jGwB2IQuAsRMedWFQPMYU2yGCylE3y4bQXEbLBsVSvm87SWiJl" +
       "3HyQaMqqp7I7pg2ndNwb8umumsm0gDKwsptSTQxpobDfEGrhyldmyIRZZbrs" +
       "4RqG9VjEEGtBrb9AXSd3VTdEEg51U5KUg0gvVkI089oK4QrRbtmur+u4GI3U" +
       "mbCk0aazDjEXWSX8ikcBwsS5IQDEbfAjsW3YqR71etJw3kj62+ViqaLikomx" +
       "nrHqc22MnO0ahLxs2IN6RFOpj6dCK65XE7TVVXSrpmMkavtruqaFbXrdoIxe" +
       "1nMnmEkvQS7eqdekNOmrnJ2wicchk3HX6E9iABny0mkY89BjnZRuNJrsgNpS" +
       "NZFy2sFwIOJNdadigUdN1DHsoxi8dVxD5xJ1nrfaFS6riCEQo2bwcmliNGNQ" +
       "qIBkOdGsk2grM+h+f9eopT7fYzhivpFifmKRQt4OhC3Rbmlx26OWoxh4Vm27" +
       "TXqqKyODrLdatJJKf7jt+OvqKMGtDhlKm2yGms2JYVKeaSZmSk5Bf9GcJJqy" +
       "JhLDVV2U1FSMuwojjcKeIk+JMJxVOVtrecZmaHca6sZZ9evtqFmtVRRysRRN" +
       "RPVUalpH8wWJbb2GaUeEM7Em/GIl1zryZlqf5n4QgjcCuLtb1OpU4mNjNppL" +
       "s2QpOvaC3nrNvmKjPtptGDN+InVgsqnLSktIK27FMNhUbsIZMsbX89ZMgJO6" +
       "CfeS+aa+Q5AqttpqtmvlcgPRzOkAW7ALYY0ibqBoYkMHi2bXH1pLZAX3tkLm" +
       "+luq3xhJvUzrtnIz6WLELGRlP0vr2z61g0fOqM2Mo0F/Qc59tRLKojRDuRRZ" +
       "1+OGlqz5dbCcByLnchg5aXdaumjVCHQpd3cwwqMCO6opAdzpBE41XCcjH8/J" +
       "zI2EFiJqqwFcmeayXY0SUot9AxPdXHDs7VSD8a6s8F7QpmqtuUF1avNuPRZz" +
       "d4cy47mzphGN2em8xswxTFzV56OeNO6vE7dBjKfjJtap9vuzrSSCtWQYhdtM" +
       "QUFsrtHcRFpxkFt9blvHeY7sc2vTxDayvlqIhjxsjvHavGHZ26wWEdtuH5MW" +
       "1CCstOdCBa0yA3GTbBgCobXEnWWGhsYGHPXI4VCzR0wkwk6lvyTBS0pMrQQi" +
       "HxKcj5vtiaKbeYdqRM0KL9HSfDQZgiQw3cabYI0FTJ2foZOlbQxxobVFmtsm" +
       "eGNaNgWHybKOxxqhPFAqmgav/SDCJNbrdwmN4APWYq24I9VHlaw5DPvyOKQr" +
       "HsZsdFZqcrkzaLfwRszAndxuG7sYJkByWGwD/N13tz3xeLkTc3JgZGO3iobP" +
       "vIsdiH3TS0Xhn2xblb8HoQuHDM5sW535dnTyie0vvIMdrPl+0zSEnrvXwZFy" +
       "a/mLn3ztdWXyk8jB0U7fMoYeij3/L9rqVrXPyL5c1q2Tcb+nGCYKLvxo3PjF" +
       "7bZTy7ybDcyjbeLi7/pY3Xdy0oDyZGmvcsH0lfvsZf5CUfxsXJz8MOO77ixt" +
       "PVM5ndI33m5T6ayAC1Yq9iOhD4JLPrKS/GdjpUunBOuS4Jfvo/CvFMUvxdBj" +
       "uhof72kefZD/xKmaX/1TqHm9ePgkuPQjNfU/GzXPavHP7tP2z4viazF0FWh4" +
       "vJm+PlXt6+9GtQwEwMmxleID/NN3HI/bH+mSv/T69WtPvc7/y/0XueNjVw9R" +
       "0DUtse2zHy7P1B/0Q1Uzy1E/tP+M6Ze334mhl9/ezWPoSnzypeRf7Dl/N4ae" +
       "vR8ncOjidpbl38TQU/dgKbahy8pZ+rdi6MZFejCU8n6W7g9i6OFTOtDVvnKW" +
       "5D/E0GVAUlT/o3+XXez9x+Ls0hnoOXK3ciqfeLupPGE5e4qk+DpUnoU8/pKT" +
       "7E9D3pa//DrJfPzbzZ/cn2KRbSnPi16uUdDV/YGak69BL92zt+O+HiQ+9J3H" +
       "vvLQB46h9LH9gE9d/8zYXrj7eZGB48flCY/8Hz71C9/991//vXJT/f8AQ1e5" +
       "aKQqAAA=");
}
