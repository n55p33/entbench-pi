package org.apache.batik.svggen.font.table;
public class CoverageFormat2 extends org.apache.batik.svggen.font.table.Coverage {
    private int rangeCount;
    private org.apache.batik.svggen.font.table.RangeRecord[] rangeRecords;
    protected CoverageFormat2(java.io.RandomAccessFile raf) throws java.io.IOException {
        super(
          );
        rangeCount =
          raf.
            readUnsignedShort(
              );
        rangeRecords =
          (new org.apache.batik.svggen.font.table.RangeRecord[rangeCount]);
        for (int i =
               0;
             i <
               rangeCount;
             i++) {
            rangeRecords[i] =
              new org.apache.batik.svggen.font.table.RangeRecord(
                raf);
        }
    }
    public int getFormat() { return 2; }
    public int findGlyph(int glyphId) { for (int i = 0; i < rangeCount;
                                             i++) { int n = rangeRecords[i].
                                                      getCoverageIndex(
                                                        glyphId);
                                                    if (n > -1) {
                                                        return n;
                                                    } }
                                        return -1; }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAL1ZfWwUxxUfnz/xN+bLAWzANiA+chdoaIVMScDYYHoGCwNR" +
                                                              "TYLZ25u7W9jbXXbn7DOU5qOKoFWLKAVC2sR/NCQQRCCijdqqTUoVFRIljRRC" +
                                                              "m6ZRoF9qaSkqqGpalbbpezO7tx/nM0Vqaunm9mbfm5n35vd+78341HVSapmk" +
                                                              "mWoszIYNaoU7NdYrmRaNd6iSZW2EvgH5iWLpL1uvrlsaImX9pDYlWT2yZNEu" +
                                                              "hapxq580KZrFJE2m1jpK46jRa1KLmoMSU3Stn0xSrO60oSqywnr0OEWBzZIZ" +
                                                              "JeMlxkwllmG02x6AkaYorCTCVxJZEXzdHiXVsm4Mu+KNHvEOzxuUTLtzWYzU" +
                                                              "R7dLg1IkwxQ1ElUs1p41yQJDV4eTqs7CNMvC29UltgvWRpfkuaDlxboPbx1I" +
                                                              "1XMXTJA0TWfcPGsDtXR1kMajpM7t7VRp2tpJPk+Ko6TKI8xIW9SZNAKTRmBS" +
                                                              "x1pXClZfQ7VMukPn5jBnpDJDxgUxMss/iCGZUtoeppevGUaoYLbtXBmsnZmz" +
                                                              "VliZZ+LhBZFDT2ytP1tM6vpJnaL14XJkWASDSfrBoTQdo6a1Ih6n8X4yXoPN" +
                                                              "7qOmIqnKLnunGywlqUksA9vvuAU7MwY1+Zyur2AfwTYzIzPdzJmX4ICyf5Um" +
                                                              "VCkJtk52bRUWdmE/GFipwMLMhAS4s1VKdihanJEZQY2cjW2fAQFQLU9TltJz" +
                                                              "U5VoEnSQBgERVdKSkT6AnpYE0VIdAGgyMrXgoOhrQ5J3SEk6gIgMyPWKVyA1" +
                                                              "jjsCVRiZFBTjI8EuTQ3skmd/rq9btn+3tkYLkSJYc5zKKq6/CpSaA0obaIKa" +
                                                              "FOJAKFbPjx6RJr+8L0QICE8KCAuZ73zu5v0Lm8+9JmSmjSKzPradymxAPhar" +
                                                              "fXt6x7ylxbiMCkO3FNx8n+U8ynrtN+1ZAxhmcm5EfBl2Xp7bcP6zj5yk10Kk" +
                                                              "spuUybqaSQOOxst62lBUaq6mGjUlRuPdZBzV4h38fTcph+eoolHRuz6RsCjr" +
                                                              "JiUq7yrT+W9wUQKGQBdVwrOiJXTn2ZBYij9nDUJIOXxINXyaiPjj34zQSEpP" +
                                                              "04gkS5qi6ZFeU0f7rQgwTgx8m4rEAPU7IpaeMQGCEd1MRiTAQYo6LwaTSapF" +
                                                              "EjoylBRTKTDUIFiTpF26mZbY4jDCzfh/TZRFiycMFRXBZkwPUoEKUbRGV+PU" +
                                                              "HJAPZVZ23jw98IaAGYaG7StGFsPcYTF3mM8dFnOHce4wnzscmJsUFfEpJ+Ia" +
                                                              "xN7Dzu0ADgASrp7X99DabftaigF0xlAJuB1FW3zJqMMlCofdB+QzDTW7Zl1e" +
                                                              "9GqIlERJgySzjKRibllhJoG15B12YFfHIE252WKmJ1tgmjN1mcaBrAplDXuU" +
                                                              "CrQI+xmZ6BnByWUYtZHCmWTU9ZNzR4ce3fzwPSES8icInLIUuA3Ve5HWc/Td" +
                                                              "FiSG0cat23v1wzNH9uguRfgyjpMo8zTRhpYgKILuGZDnz5ReGnh5Txt3+zig" +
                                                              "cCZByAE7Ngfn8DFQu8PmaEsFGJxAbKj4yvFxJUuZ+pDbw9E6nj9PBFjUOnHZ" +
                                                              "asco/8a3kw1spwh0I84CVvBs8ek+4+mfv/WHT3B3O4mlzlMR9FHW7iEzHKyB" +
                                                              "09Z4F7YbTUpB7oOjvV87fH3vFo5ZkGgdbcI2bDuAxGALwc2Pv7bzvSuXj10K" +
                                                              "uThnZJxh6gwCncazOTvxFakZw06YcI67JOBDFUZA4LRt0gCiSkLBIMTY+mfd" +
                                                              "7EUv/Wl/vYCCCj0OkhbefgC3/66V5JE3tv6tmQ9TJGM+dt3migmSn+COvMI0" +
                                                              "pWFcR/bRi01PXpCehnQBFG0puyhn3SI73HFRjZA8uKaihzdIWlxPr5CB6awu" +
                                                              "4G++sUu42D28vTdfeYKj3L2+MytTAxfE9ZZiM9vyBo8/Pj1F14B84NKNms03" +
                                                              "XrnJTfVXbV6s9EhGu4AnNnOyMPyUILmtkawUyN17bt2D9eq5WzBiP4zIjVpv" +
                                                              "AstmfciypUvLf/GjVydve7uYhLpIpapL8S6JBykZB9FBrRQQdNa4736BjKEK" +
                                                              "aOrxKUtyjiHcMSSb14G7M2P0fe9MG4zv1K7vTvn2suMjlzlKDTHGNK4fwpzh" +
                                                              "Y2Ve+7vEcPKdT/30+FePDInqYV5hNgzoNf5jvRp77Nd/z3M558FRKpuAfn/k" +
                                                              "1FNTO5Zf4/ouIaF2WzY/zwGpu7qLT6b/Gmop+3GIlPeTetmutTdLagbDvB/q" +
                                                              "S8spwKEe973314qiMGrPEe70IBl6pg1SoZtf4Rml8bkmwH5YnJBp8Jlhs8KM" +
                                                              "IPsVEf7Qw1Xm8nY+Nnc7ZFNumAqcx2iAaqrGGJSRShPMAy7IwBHEl5Yx9fVl" +
                                                              "YhakUCUNjDloF5qLe7fJ+9p6fytgcNcoCkJu0onIVza/u/1NzscVmKQ3OqZ7" +
                                                              "UjAkc08yqBcr/wj+iuDzb/zgirFDFGwNHXbVODNXNiKMx8RjwIDInoYrO566" +
                                                              "+oIwIAi+gDDdd+hLH4X3HxIMK84erXnlv1dHnD+EOdg8gKubNdYsXKPr92f2" +
                                                              "fP/Enr1iVQ3+SroTDoov/Oxfb4aP/vL1UUq2YsU+P3p5E9Kkf2+EQau+WPeD" +
                                                              "Aw3FXZDeu0lFRlN2Zmh33A/ScisT82yWe6ZxgWubhhvDSNF82AORnLFdhs06" +
                                                              "gcL7ClLZaj/058Jnpo3SmQWgL6AyF5vefIwX0makmmN8A5V1M275b0JyoOW5" +
                                                              "TLjowarzP7Se+d1ZsRWjhUTg7HXieIX8fvo8DwmccpPftCnBxX0sxwE8Q66i" +
                                                              "iY//3DHKRAjx2YUD0OPbkeda33p4pPVXPFtWKBbQJlDAKGdij86NU1euXaxp" +
                                                              "Os0r0hJkEhuY/suE/LsC3xUA35k6bPSsU1SE/4uzzgYXO4ZhkGCc4U85CP7U" +
                                                              "GODPFuTvMiMTUxXZpW/+V0YCp1Zvpeimb4J70FToYoFTzLHHDo3E1z+7yIHp" +
                                                              "VqhPmW7crdJBqgYqgSZfJdDD/eim1Q9qD/7me23JlXdyNMO+5tscvvD3DADD" +
                                                              "/MJYCi7lwmN/nLpxeWrbHZyyZgS8FBzy+Z5Tr6+eIx8M8Xsjke/z7pv8Su1+" +
                                                              "Aq00KcuYmp8yW3P7Wof71QifBfa+LggSnosnzna7/WxXOYZqoIp2akP8/eUx" +
                                                              "3u3HZi8AIkmZiGzs2OxCet/t+Hzs0hQ7Og3e/4V8P0RsYyJ37odCqqOfJrhR" +
                                                              "fNQnx3DGN7A5BM5IQNSsVoeNVMAZh/8XzsjCkSNwkYIVfGPeFa64dpRPj9RV" +
                                                              "TBnZ9K6gQedqsBrCJ5FRVW+N6XkuM0yaULhV1aLiFJn6GUZabk9+jJTyb27C" +
                                                              "N4Xmc1D8jqXJSAl+eVWeZ2RKARVgPfHglT/FSH1QHpbCv71yZ6B8deVgKPHg" +
                                                              "FTkL1RGI4OO3DIf2F9zBFVe2yE+yOQxMuh0GPLzc6uMzfpXvcE9GXOYPyGdG" +
                                                              "1q7bffOTz4r7C1mVdu3CUaogjYmrlBx/zSo4mjNW2Zp5t2pfHDfbYfrxYsFu" +
                                                              "NE3zoL0T4sJA5E0NnOytttwB/71jy175yb6yi5C2t5AiCY7jW/IPR1kjA4lj" +
                                                              "SzS/7ASu51cO7fO+Prx8YeLP7/PjJxFl6vTC8gPypeMPvXOw8VhziFR1k1II" +
                                                              "R5rlp7ZVwxrk5EGzn9QoVmcWlgijKJLqq2lrMUgkvOTnfrHdWZPrxdsviIP8" +
                                                              "cj7/zhCO6kPUXAnHpLhdfFS5Pb7/MTgpIGMYAQW3x1ORxLB5IIu7AVAdiPYY" +
                                                              "hnPaqVptcKqQC9cc5/kjNhf+Axrj9ejmGwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
