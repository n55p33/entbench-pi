package org.apache.batik.css.engine.sac;
public abstract class AbstractCombinatorCondition implements org.w3c.css.sac.CombinatorCondition, org.apache.batik.css.engine.sac.ExtendedCondition {
    protected org.w3c.css.sac.Condition firstCondition;
    protected org.w3c.css.sac.Condition secondCondition;
    protected AbstractCombinatorCondition(org.w3c.css.sac.Condition c1, org.w3c.css.sac.Condition c2) {
        super(
          );
        firstCondition =
          c1;
        secondCondition =
          c2;
    }
    public boolean equals(java.lang.Object obj) { if (obj == null ||
                                                        obj.
                                                        getClass(
                                                          ) !=
                                                        getClass(
                                                          )) { return false;
                                                  }
                                                  org.apache.batik.css.engine.sac.AbstractCombinatorCondition c =
                                                    (org.apache.batik.css.engine.sac.AbstractCombinatorCondition)
                                                      obj;
                                                  return c.
                                                           firstCondition.
                                                    equals(
                                                      firstCondition) &&
                                                    c.
                                                      secondCondition.
                                                    equals(
                                                      secondCondition);
    }
    public int getSpecificity() { return ((org.apache.batik.css.engine.sac.ExtendedCondition)
                                            getFirstCondition(
                                              )).
                                    getSpecificity(
                                      ) +
                                    ((org.apache.batik.css.engine.sac.ExtendedCondition)
                                       getSecondCondition(
                                         )).
                                    getSpecificity(
                                      ); }
    public org.w3c.css.sac.Condition getFirstCondition() {
        return firstCondition;
    }
    public org.w3c.css.sac.Condition getSecondCondition() {
        return secondCondition;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "is3V/wLunHX+ZRwAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL1aecwjSXXv+XZndmZYZmZ32YOFvYeFXZOvfbTdtgYSuu22" +
       "3YfttttuHwkMfbvtvu822QRW4RBIG5QsRxTYvyAHWo6gkCBFkE0iAghERIRy" +
       "SQEURQoJQWL/CImySUh1+7vmm2OzAsVSl8td7716r+q9X1W98rM/gE76HlRw" +
       "bCPVDDvYVZJgd2VUd4PUUfxdiqmygucrctMQfH8M3l2WHv7M+R+98P7lhR3o" +
       "1AK6Q7AsOxAC3bb8keLbRqTIDHT+8C1hKKYfQBeYlRAJcBjoBszofnCJgV52" +
       "hDWALjL7KsBABRioAOcqwNghFWB6uWKFZjPjEKzAd6Ffgk4w0ClHytQLoIeu" +
       "FOIInmDuiWFzC4CE09lvHhiVMyce9OCB7VubrzL4AwX46Q+95cJnb4LOL6Dz" +
       "usVl6khAiQB0soBuNRVTVDwfk2VFXkC3WYoic4qnC4a+yfVeQLf7umYJQegp" +
       "B4OUvQwdxcv7PBy5W6XMNi+UAts7ME/VFUPe/3VSNQQN2HrXoa1bC9vZe2Dg" +
       "WR0o5qmCpOyz3LzWLTmAHjjOcWDjRRoQANZbTCVY2gdd3WwJ4AV0+3buDMHS" +
       "YC7wdEsDpCftEPQSQPdeV2g21o4grQVNuRxA9xynY7dNgOpMPhAZSwDdeZws" +
       "lwRm6d5js3Rkfn7Qf8NTb7O61k6us6xIRqb/acB0/zGmkaIqnmJJypbx1seZ" +
       "Dwp3feE9OxAEiO88Rryl+cNffP5Nr7//ua9saV51DZqBuFKk4LL0MfHcN1/d" +
       "fKxxU6bGacf29Wzyr7A8d392r+VS4oDIu+tAYta4u9/43OjP52//hPL9Hegs" +
       "CZ2SbCM0gR/dJtmmoxuK11EsxRMCRSahM4olN/N2EroF1BndUrZvB6rqKwEJ" +
       "3Wzkr07Z+W8wRCoQkQ3RLaCuW6q9X3eEYJnXEweCoAvggR4Ez0PQ9vNAVgSQ" +
       "BS9tU4EFSbB0y4ZZz87s92HFCkQwtktYBF6/hn079IALwranwQLwg6Wy1yD5" +
       "Ga0GdIJ9QYIxEfi7IAVN2xR1ECS2ByJLzgdhN/M75/+9xyQbgwvxiRNgel59" +
       "HBwMEFdd25AV77L0dIgTz3/q8td2DoJlb/QC6BJQYnerxG6uxC5QYnerxC5Q" +
       "YvcGSkAnTuR9vyJTZusWYFLXAB4AcN76GPdm6q3vefgm4I9OfDOYkYwUvj5+" +
       "Nw8BhcxhUwJeDT334fgd/C8Xd6CdK4E4MwC8Opuxsxl8HsDkxeMBeC2559/9" +
       "vR99+oNP2IeheAWy7yHE1ZxZhD98fKg9W1JkgJmH4h9/UPjc5S88cXEHuhnA" +
       "BoDKQADjCVDo/uN9XBHpl/ZRM7PlJDBYtT1TMLKmfag7Gyw9Oz58k/vAubx+" +
       "Gxjjc5nrPwae4l4s5N9Z6x1OVr5i6zPZpB2zIkflN3LOR//mG/9cyYd7H8DP" +
       "H1kSOSW4dAQ0MmHnc3i47dAHxp6iALq//zD76x/4wbt/PncAQPHItTq8mJXA" +
       "tbIVEAzzO7/i/u13vv2xb+0cOk0AnXE8OwBxpMjJgZ1ZE/TyG9gJOnz0UCWA" +
       "OwaQkDnOxYll2rKu6oJoKJmj/tf515Q+969PXdi6ggHe7HvS619cwOH7V+LQ" +
       "27/2ln+/PxdzQsrWvcNhOyTbgukdh5IxzxPSTI/kHX953298WfgogGUAhb6+" +
       "UXJ028mHYSe3/M4AemUWr3FFysM0i8+DaMwIivn0wjnx43m5m41LLgLK2ypZ" +
       "8YB/NEyujMQj25jL0vu/9cOX8z/84vO5UVfug456RU9wLm0dMSseTID4u49j" +
       "Qlfwl4AOea7/CxeM514AEhdAogRw0B94AKWSK3xoj/rkLX/3J39211u/eRO0" +
       "04bOGrYgt4U8HKEzIA4UfwkALnF+7k1bH4hP768GCXSV8VvfuSf/le0kH7s+" +
       "ErWzbcxhMN/znwNDfPIf/uOqQcgx6Bqr9zH+BfzsR+5t/uz3c/5DMMi470+u" +
       "Rm6w5TvkLX/C/Ledh099aQe6ZQFdkPb2k7xghFmILcAeyt/fZII95xXtV+6H" +
       "tov/pQOwe/VxIDrS7XEYOlwxQD2jzupnr4U8rwXPo3sR+ehx5DkB5RUsZ3ko" +
       "Ly9mxWu3gZ5VX7cX4T8GnxPg+Z/syeRkL7ar+u3Nva3Fgwd7CwesY+dU3fOD" +
       "K4NhC3VZiWQFvhWOXtdd3nClMa8DT2HPmMJ1jKFuaExWEiBUfAXMjHxD5egX" +
       "VS4XlpwAgHiyvIvu5gKG1+7+pgAcNULR0AEMnfLzUwDgUsHybezrdPfKkC7u" +
       "DyUPTgVAr4srA93HmQt5LGaus7vdSh/Tl/g/6wti7dyhMMYGu/L3/eP7v/6r" +
       "j3wHBAQFnYwyZwVxcKTHfpgdVN717Afue9nT331fvhiAMeV/5YV735RJffN1" +
       "rM6qk6zgs2K6b+q9malcvudiBD/o5eCtyLm1N8QB1tNNMGHR3i4cfuL276w/" +
       "8r1PbnfYx4P+GLHynqff++Pdp57eOXKueeSqo8VRnu3ZJlf65Xsj7EEP3aiX" +
       "nKP9T59+4o9+54l3b7W6/cpdOgEOoZ/8q//++u6Hv/vVa2z+bjbsn2Big3Mf" +
       "6SI+ie1/mNJCncaTJJmqg0pdVBG2mthYMsEGVS3l1rY+LyL9FV7txP64ueH7" +
       "lF6NxpaKeBV5MVMHrBPWWguC4/oTbajpS15hCpMR5lDDdnslu0VqRrdNe2h6" +
       "C47or4se1+entFmmO8bQ8Cae2GAqi0gOG9GwzriKQQ1QqVJvoD2lDCsFtFiR" +
       "ykq0TpgxSZR61SFRcFa9TZHupjPTnTN9Opz0Wak5K7eKQb/d6BRQD+b9OsVy" +
       "GE+O7bJQGRGVKT3uGXOtNhyJlCu5Dr0ZJEuGJKVoON+Y43YzFFIHq41GfS/S" +
       "Q51ieiE8JbWYKrjrERlNJ1KxN6A2KxBtqrZoEySFrWluTouR1A9InjQE1Z0P" +
       "N+hsJKNhZ92lQ2YwTSeGLDTrsi0RhFHlNa61qE4bpOZW+H5nFHB9vKpxI3Tu" +
       "1tLKWMSCoIUyeK9iCZtCQeFGU6oYx+ua6yY2X6tqVVPwbVJHRqQns6ItNpFw" +
       "3qibI66dYvGsx4HVVeb0Ia8Vm2RoBt2pPWQd19FFHV04w2VNNulgYrRJfews" +
       "zHGtz2nSLBRmOrHZtFsDUS62e2Udpehy4EynU31dCFrLKqpYqqwXp2vZbk1S" +
       "01Z1fYATeDztDJst39LnHUU0OXLUxtd6o+lEchKnCzqikUju9Z1Vup44NQyd" +
       "FBb42B8PVixh2rVgjjfwftpbSlKJdBOJb5kzmLbXrowti5ZSsQXTmutqWZvT" +
       "k562NEZNq2r5yZBNyy6xrvPKyuMGjCq1MLE5TUYmKyimoRsTuiuMcWnZabtr" +
       "FmctrCEPlyS3GcVDcjAuzNbWiI88HnfNYTkesjLVKpX9PsZP2z2MS6U+Y1Oj" +
       "3ibm0H6jkHJCpRA2ynE9asOyG7lUq8wNeoSBF6YSNqkOusJQYXp2H++29R4v" +
       "BM2kYPlNRK0vMTyxEXVuR5ZilFHJry2cmjVlFmtiYIaVZTTZ6FqDoaReSWw2" +
       "ArGfcMvOYFpb+C5SGJmCnq68YKIK65WtbQab4qqlzTmsNEBnq1IzLsjzEYxw" +
       "08mMXkyK1IjosjV3FjBaSNdTZFWzejaVtMO11p6kbDD3UsbotVGuLSxKot/o" +
       "rCYLNGXaeqi5JWkU9drExFljY16iUY8QSiUmGCiTtE5V+CaHF+sLbF3nEKs0" +
       "ncd9qmzHjs8DM5yJwU+CciewXaa+wHtDSiuXVvEYR+BZa1jCyU7YwYc9RGi2" +
       "2VhLwhhPJ2OBXGCO0CadsLXuwWvEqLhoO96QhD5dYAtiShBDxpZhD1alybps" +
       "tky3V++WUXbYjBE6AXgxnq/jeQmrGcGKk5RBOx5LflLva75Q6XIjnyTEJtHE" +
       "tCWm40SMkzpGkERTW+Jqq5Y0dIBtFsmU+6OlhqlYteZNI02poGNrMsPGBZes" +
       "T2ME0YRZv2OZTqXXHLZhkuXCuejWBX5WKlWK6wI5FOZNniiN8YBhFx0MIAAi" +
       "BiZdp4fxYkP4a45PGbzVWdqE7WOrkGdodu5XZZvsoU11XTLDDk85La1XM1sw" +
       "VaU4dUwV56zcgg2RLyA+3OuKy3VTwhQ/knTEVUaRNGU6omV64xKCKv1NkkpF" +
       "fFNM1wbhLsuLxNbQ/iyEY9OUh1NvSkSrETIXqLbJFJtFqjSWMALb6GLUWVpa" +
       "iZo3lYAzujg3ENaCRK/0iW8RxiqxBLffW1WYhRL16s2gtsKFTrm9qBXlKCTF" +
       "UVn1yr1aUsE3jQ09aHPNUaVRsFg49CwVdVpmK+SlsiMnE1JFysXQ6rFUR+P0" +
       "0jgIw0Zfaw300BosG3XX8vCKRFnxlF6I66nYI6a21hkDkKiuZbUSqWqhtBjM" +
       "4HlNlUr0spO43WJHGS3aDtttMjyucgTOSwgJXJteYa3BGmWw1EVcPOUFfgmi" +
       "PoJdo1xA3SncpWubGdHBLWdoeQujgLkyXFmKaREPUbiBrJ2oTZm0LfsbY92O" +
       "UFbuiIqIL4utAU92rSValGXVrjealNYt9kM+obTWgqlvtHbVY6vToTL0N3Z3" +
       "QWFtm5v0SUyL+ZKuNCQG8aZ6NGID0p1rczNu9f2gL1eX65FLe/WlO1kZm4LP" +
       "eHBcksMmPUm5jVLhK6NxJJXSUSeZUp1ubcAj83LR63f6LXkgzzbJ2DFqutgb" +
       "YNiG01py1Zq3tNZ0gUx6ZXliLbxKoy6pghIgLhlV+xN66fblNjlaucMmYjcX" +
       "Pam1dli0qqSx2mmWWErE1ilPFtyYrcxn3bCr1MhaaeOn6qpSrSQVpGBRbp1U" +
       "5Wk4wFWhM6Q8Mm43EqyLaUgvRi240q5xymBVso1RJyhUWDbeqBWwP57V6wO4" +
       "sJ7yqTbTqunSZ+FiK0Zb7Ka8kRskq8k1ohsa5qgsaCwiW8uITVg47TekwrIH" +
       "0yNfkxeULLHymJoTODvE245jurFL2JtkxTK4HtRcLWgJRSYSW9Y0mDPKukov" +
       "Z8o6iVR31tIrhIPwcpRG9QEtrRB9VohnDGcm00Wt32XN6kBwybRLDVOtHjbH" +
       "ZgwvixWybitoHXXUUU1ALKRtBWJFq602OqprtriqhjohjOPZgmj6nsgXcUUo" +
       "64bQlpdSNTKqo3QwBbhktedVWpDLdYXWfHY1cWyPKDGSuJSL+DwFIGDGRJq6" +
       "nYk39hw9tAcOKQkGatIkOvfTlepOOpJCIAW1E6d+VJkMdD/ubEivPkQQoYXC" +
       "aaUAd8arpFz0q00vpr3QrNDTlKDBWqVbXarVXNltTXKpWi0sgTiFJT8YloLQ" +
       "GXqtyAXrj76pRyN9MqUm6kxM9YgVY6ugRhV8LEqx3y5NaXYglsaqF6EoPUP5" +
       "9bILK0xRwPh6yV1v1rV10KvHXmsodhdd3hp5WMSh0WLMcq6i4r7fL/nDQk0H" +
       "OyumAOMloyanbjOOTU6uFsIkLcMiOXCIhBgMm21fp4J5sdmZSURng1O07HfL" +
       "5apZCis2PitSTTpRhkithSHwfNkYiwosk8uSU4PLALbFWGrhCxmpsHgCR2pF" +
       "Dc1yr5o2qEKR4MsFrIKa7lL0mHZQx5Z1lWVhHK/N2q0o7tCdQmVcTZjiWh5s" +
       "uki7WF12NQWsFXDU2pQStGIwmIn26slgM/SFRoFYLesb0kZqjao+lUVeW0Td" +
       "0AvjUq9tskW3EvQxV3PZzaogmWq0khKiA0djJR4bxryYjDolIe4vE7JaLKRT" +
       "j5UKfBSuyLjUtkYtZiYM67bkoYQbe+vQYhfTuY727S5Yl1r1aVUUvGGVQqu8" +
       "q1BNrMvXQ3/EhTSKr6yF3OipnGjX7fFIxIvlDqpOFLzTozopUpurdNy22AKF" +
       "mX12HvVKHMO3VqzqjEmamzpM1aTxftkJ6VkyCBvxQGr3rHJXwD0fbll2ijBs" +
       "hDhTBhslKD6sMd1+sct6bX/Tnfo4XUntWNZckZugbjyn5bI6pedII1INrxzj" +
       "tF8pCS7cEIP1vFDSeqjVRNKG3itVMAYe2hVyMiKr+CZCohbFrBcAmztJsT7v" +
       "bcB5USh7a8FopwsvLcg9NmqGNGZxparMYwNmtKRphCu3ZkrNCH0QXjxdTpsm" +
       "JatsESNCpGiMGKIljprrqhQ4mq+pQwJs51d6IhU3iWT6s1YcD9BRmNrhkPbK" +
       "E4viSHGjym41mQwsLnbZmU55a8KPe1QUVSebaqGrCjVuxeix3e3UvEltEw7q" +
       "do8pUGpCcWBjtIQXUkxTZbHSFzZwfSE7tRgl1uYSKfSQNE4xVQlrlFFEGKmI" +
       "TstuWHTLQb8cDfg0YatCv8aVMUvCBSRifFkjql2n6kXhuBhPG/SsOSjIFXZF" +
       "b+IaH2nlhYyryWRSNVHfLhj6rIS3OT8sMovasEyPu52gKIu1ldjuCzUKhsEx" +
       "rYCTXpdDe+NN3Z6N0QbSCrrVatWvO70F8DtiopcYAAB6NGXdli70O9hgPV3N" +
       "0bWO6ZsmNaa4fqXktuAJnLJDedXum3IpXMpRubV0Ni5C+mHdoBM+MHBDDMCW" +
       "yBfZqEVLFpLWB4Pa3CVQL5zPsqibjcnSfBoHRUxN4p6sAPg2MReeaDOdxW3U" +
       "4wh0NEt0v8LDMRNa3VlhMYrBYfSNb8yOqdZLyxTclidFDi4bVwaaNcxfwgk5" +
       "uXaHO3mHAXRa2LtNOcxk55/z+7dW+99HM9mHecuDLPAjV2eBr7qd2actvdgN" +
       "D5EEiiUrh/mpLPFw3/WuMfOkw8eefPoZefDx0s5eVlkPoDOB7fyMoUSKcUTh" +
       "m4Gkx6+fYOnlt7iH2c4vP/kv945/dvnWl3Db88AxPY+L/N3es1/tPCr92g50" +
       "00Hu86r75SuZLl2Z8TzrKQHYpo6vyHvedzB/d2TT9UrwNPbmr3E8VXjoPtfO" +
       "E0627ncsaX9i787s6nzcNpWbM733Bpn+p7LinQF0SnFDwfBzGvmI/y4D6BbR" +
       "tg1FsA59+10vlv052kv+4smDkcicGLoPPMTeSBA/nZE4atRv3qDto1nxwQA6" +
       "p4EjiqNIuqpLepBey/Cb9L0/ZeRGf+gnMPrO7GWW6u7vGd3/6Rv9iRu0PZsV" +
       "HwfQBYxuX50CPzTyt35SI7PcPr9nJP/TN/IPbtD2+az4vQC6PZvZa+TSD638" +
       "7EuxMgmgV93geju7qLvnqv/cbP8nIn3qmfOn735m8tf5De/BfznOMNBpNTSM" +
       "oxcmR+qnHE9R9dykM9vrEyf/+mOASS+C0sBnQZmb8MUt058C7W/AlAV+XjnK" +
       "86UAesW1eIB0UB6l/AqAnOOUAXQy/z5K97UAOntIBzrdVo6SfANIByRZ9S9y" +
       "d3lfcuLIGrHnbfn03f5i03fAcvQ+OVtX8r9Q7a8B4fZPVJelTz9D9d/2fO3j" +
       "2/tsyRA2m0zKaQa6ZXu1frCOPHRdafuyTnUfe+HcZ868Zn/NO7dV+NDzj+j2" +
       "wLVvjgnTCfK73s3n7/79N/z2M9/Orzb+F2G8Vq7bJgAA");
}
