package org.apache.batik.dom.svg;
public interface ExtendedTraitAccess extends org.apache.batik.dom.svg.TraitAccess {
    boolean hasProperty(java.lang.String pn);
    boolean hasTrait(java.lang.String ns, java.lang.String ln);
    boolean isPropertyAnimatable(java.lang.String pn);
    boolean isAttributeAnimatable(java.lang.String ns, java.lang.String ln);
    boolean isPropertyAdditive(java.lang.String pn);
    boolean isAttributeAdditive(java.lang.String ns, java.lang.String ln);
    boolean isTraitAnimatable(java.lang.String ns, java.lang.String tn);
    boolean isTraitAdditive(java.lang.String ns, java.lang.String tn);
    int getPropertyType(java.lang.String pn);
    int getAttributeType(java.lang.String ns, java.lang.String ln);
    java.lang.String jlc$CompilerVersion$jl7 = "2.7.0";
    long jlc$SourceLastModified$jl7 = 1471028785000L;
    java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAALVZe4xU1Rk/M8u+F/bBawV2eS2kPDqjtjSRpeDusguLszBl" +
                                          "gaZLZfbMnTMzl71z7+XeM8ssSENJGtcmUkJBrVH+UAzaqJBG+0jFYEyrRmuj" +
                                          "0lrboiY2rdqSSpq0f2Brv++cO3Pv3J0dk5YhuWfvnPud73zn970PT14l1bZF" +
                                          "OpnOQ3zCZHaoX+dRatks0adR294FczHl/ir6j30fbr8tSGpGyKw0tYcUarMB" +
                                          "lWkJe4R0qLrNqa4weztjCVwRtZjNrHHKVUMfIXNVezBjaqqi8iEjwZBgD7Ui" +
                                          "pJVybqnxLGeDDgNOOiIgSVhIEu7xf+6OkCbFMCdc8nYPeZ/nC1Jm3L1sTloi" +
                                          "++k4DWe5qoUjqs27cxZZYxraREozeIjleGi/ts6BYFtk3RQIll1o/uf1E+kW" +
                                          "AcFsqusGF8ezdzLb0MZZIkKa3dl+jWXsA+RbpCpCGj3EnHRF8puGYdMwbJo/" +
                                          "rUsF0s9kejbTZ4jj8DynGlNBgThZWszEpBbNOGyiQmbgUMeds4vFcNolhdPK" +
                                          "U0454uk14VP372v5URVpHiHNqj6M4iggBIdNRgBQlokzy+5JJFhihLTqoOxh" +
                                          "ZqlUUw85mm6z1ZROeRbUn4cFJ7Mms8SeLlagRziblVW4YRWOlxQG5fyqTmo0" +
                                          "BWed555VnnAA5+GADSoIZiUp2J2zZMaYqic4WexfUThj1x1AAEtrM4ynjcJW" +
                                          "M3QKE6RNmohG9VR4GExPTwFptQEGaHGyYFqmiLVJlTGaYjG0SB9dVH4CqnoB" +
                                          "BC7hZK6fTHACLS3wacmjn6vbNxw/rG/VgyQAMieYoqH8jbCo07doJ0syi4Ef" +
                                          "yIVNqyP30XkXJ4OEAPFcH7Gk+cld125f23npZUmzsATNjvh+pvCYcjY+641F" +
                                          "fatuq0Ix6kzDVlH5RScXXhZ1vnTnTIgw8woc8WMo//HSzl9+4+gP2V+DpGGQ" +
                                          "1CiGls2AHbUqRsZUNWZtYTqzKGeJQVLP9ESf+D5IauE9oupMzu5IJm3GB8kM" +
                                          "TUzVGOI3QJQEFghRA7yretLIv5uUp8V7ziSE1MJDAvB8jch/i3DgJBZOGxkW" +
                                          "pgrVVd0IRy0Dz2+HIeLEAdt0OA5WPxa2jawFJhg2rFSYgh2kmfMhYWTC9ngq" +
                                          "3J/jICQERouqvEcBWjuEhmZWfoscnnL2wUAAFLDI7/4aeM5WQ0swK6acyvb2" +
                                          "X3s69qo0LXQHBx9O1sKuIblrSOwagl1DsGuoxK4kEBCbzcHdpaZBT2Pg8RBy" +
                                          "m1YN37ltdHJZFZiYeXAGopwTLrgw/wMW+qQUzv7VYfPh373+0ZeCJOjGhWZP" +
                                          "QB9mvNtji8izTVhdqyvHLosxoLvyQPT7p6/evVcIARTLS23YhWMf2CAEVghQ" +
                                          "33n5wDvvvXv2crAgeBWHYJyNQ07jpI7GIZJRhXNSXwhJ8mBzPoN/AXj+gw+e" +
                                          "ESekebX1OTa+pGDkpumBIyDe2yFjTKsAD/CIXcd0oUOEvbPHTp1J7HjsFung" +
                                          "bcXu2A/Z5qnf/vu10APvv1LCBuq5YX5RY+NM8wjYgFsW1Q1DIqrmc3BMuTLr" +
                                          "5Ac/60r1BsmMCGkDhLJUwwqgx0pBblHGnPDbFIdiws3pSzw5HYsRy1BYAlLK" +
                                          "dLnd4VJnjDML5zmZ4+GQrzgwtq6ePt/7RX/p2McLdm1MjwqT82Zw3K0akg+u" +
                                          "jGLeLeTXxT74/SyfGHrylS0rlZNBkXIwfJdIVcWLur2KgE0tBrlVx+PgzEzY" +
                                          "dJnfq/1oxZTVS+izsYtHuoQW6iHvcgpxElJap3/zorTRnXc13KoOQEgaVoZq" +
                                          "+CkPeQNPW8ZBd0aEm1Zp+WAgTWjo8+FZ6gRW8Re/zjNxnC/Dk6DvFONSHLqE" +
                                          "dQXxdQUOKwXZF8DaVrreDJlAg1CJGunarYPa1aRK4xrDOPNp84pbnv3b8RZp" +
                                          "yBrM5FW09vMZuPM39ZKjr+77V6dgE1CwEnEjjksm09tsl3OPZdEJlCP37Tc7" +
                                          "fvASfRgSJSQnWz3ERL4JFLt3i1iJRUdIFh3iuH3i80Yx9iJsTojE31twWM9J" +
                                          "IxTioG9RXIEIy1xfRKMfzkJYilpqBkLiuFMI3BodVSa7on+SMeCmEgsk3dzH" +
                                          "w/fueXv/a8L669A9CzbncT5wY4/eW4SWMA6tKlNWF8sTPtL23thDHz4l5fFX" +
                                          "MT5iNnnqu5+Fjp+SapWl3vIp1ZZ3jSz3fNItLbeLWDHwl/NHfv74kbuDDt4h" +
                                          "TmrjhqExqhf0kVciZKxiFKWsm+9pfu5EW9UA+Nwgqcvq6oEsG0wUe3OtnY17" +
                                          "YHWrQ+nbHqkxaXASWG2aeICuaeD1NBAx5cTlT2bu+eT5awKs4g7EmziHqCnx" +
                                          "acWhG9nP96furdROA92XL23/Zot26TpwHAGOIuvssKB6yBWlWYe6uvb3L7w4" +
                                          "b/SNKhIcIA2aQRMDFGt9qNggaDA7DYVHztx0uwwMB+tgaBEGTqaY/JQJ9LfF" +
                                          "pT25P2Ny4XuHfjr/mQ3nzrwrUrZMq7cWByZ8WekEppX/V2Aq9tSgS7VZDIIq" +
                                          "WcafRS1KoZAAfxYpHX/fIUi/jkNcQjDyP6KFE6MlIVgCzxoHgjU3EALHOdzT" +
                                          "22VOn8UB2oc5aiGY9ehqhnKMxj4kjEohgZnpZgeJmytuDEfLwHEMh8McL00K" +
                                          "9x/T4nFXpfDohGedg8e6SlrGvWWg+B4Ok1ApeywjkRCx2ofDPZXCYTE86x0c" +
                                          "1lfcLh4sA8ZDOJzmZLbXLkqjcV+l0OiAZ5ODxqaKo3GuDBpP4PAIJ62qjJjT" +
                                          "esijlcJiITybHSw2VxyLZ8pg8WMczkNez2NR2iouVAAJZCEq/G0OEttuIBJT" +
                                          "YsULZUB4EYfnAIQU4/lgUWhMBgV7eaiI5z3KSZXqXK/6dtydc5G7WCnk2uGJ" +
                                          "OshFK25Db5WB7zc4vA7NCMBXCC/5WvQXLhS/vhFQ5CCKlbg7wrKufcodtbxX" +
                                          "VZ4+01w3/8zut0UTW7j7bILuJJnVNE9V7a2wa0yLJVVxwCZZ5ZrizxVO2qe7" +
                                          "VAGTgFGI/kdJ/T7UJqWogRJGL+UHAKCfkpNq8ddL92dOGlw6Tmrki5fkI+AO" +
                                          "JPj6MZT9sltc6AVW6GPu5+nDc7W2vKhvEP9nkO9bsvJ/DWLK+TPbth++9pXH" +
                                          "5E2botFDh5BLI3Qrsv13Gj5vG+XnludVs3XV9VkX6lfk26hWKbBr1ws9BjgK" +
                                          "fmeiBSzwNdJ2V6Gffufshud/NVnzJnQge0kACubZez039vJ6GrrxrEU69kam" +
                                          "dmV7qCU6/O5VD05sXJv8+x9Eb0BkF7doevqYcvncnW+dbD/bGSSNg6QaOkSW" +
                                          "GyENqr15Qt/JlHFrhMxU7f4ciAhcVKoVtXyz0FgpNvYCFwfOmYVZvLHhZNnU" +
                                          "RnbqtRf0UQeZ1Wtk9QSygaax0Z2RmvFdGGVN07fAnfH07rtkUERtgN3FIkOm" +
                                          "mb+orLpqCrfdXTpK4nhdvOLw6X8BlfNKTE8cAAA=");
    java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    long jlc$SourceLastModified$jl5 = 1471028785000L;
    java.lang.String jlc$ClassType$jl5 = ("H4sIAAAAAAAAALVaeewkWV2v+c25s8fM3uuyN7Mbl15+VX13M8BS1V1d3dXV" +
                                          "d3VVd6HM1n123dVdXbiIKEIgAdTlMML+oRCELEdUopGgS4wcATUYRCUKBI2K" +
                                          "QGD/8Iio+Kr6d81vjg0Zp5P3uo7ve+/7+V7vve+r574PHQ98KOc61lq1nHBb" +
                                          "jsNtwypvh2tXDrZJqjzk/UCWGhYfBDR4dkF85JNn/v1H79LObkEnOOh23rad" +
                                          "kA91xw7GcuBYS1mioDP7T3FLXgQhdJYy+CUPR6FuwZQehOcp6MYDTUPoHLXL" +
                                          "AgxYgAELcMYCjO5TgUY3y3a0aKQteDsMPOgN0BEKOuGKKXsh9PDFnbi8zy92" +
                                          "uhlmCEAPp9J7BoDKGsc+9NAe9g3mSwC/Owc/897Xnf2do9AZDjqj25OUHREw" +
                                          "EYJBOOimhbwQZD9AJUmWOOhWW5aliezrvKUnGd8cdFugqzYfRr68J6T0YeTK" +
                                          "fjbmvuRuElNsfiSGjr8HT9FlS9q9O65YvAqw3rWPdYOwlT4HAE/rgDFf4UV5" +
                                          "t8kxU7elEHrwcIs9jOe6gAA0PbmQQ83ZG+qYzYMH0G0b3Vm8rcKT0NdtFZAe" +
                                          "dyIwSgjde8VOU1m7vGjyqnwhhO45TDfcvAJUN2SCSJuE0J2HybKegJbuPaSl" +
                                          "A/r5fv+V73i93ba3Mp4lWbRS/k+BRg8cajSWFdmXbVHeNLzpZdR7+Ls+89Yt" +
                                          "CALEdx4i3tD8/s+98JonHnj+Cxual1yGZiAYshheED8o3PKV+xqP14+mbJxy" +
                                          "nUBPlX8R8sz8hztvzscu8Ly79npMX27vvnx+/Ln5Gz8qf3cLOt2BToiOFS2A" +
                                          "Hd0qOgtXt2SfkG3Z50NZ6kA3yLbUyN53oJPgmtJtefN0oCiBHHagY1b26IST" +
                                          "3QMRKaCLVEQnwbVuK87utcuHWnYduxAEnQQFOgLKCNr87kurELoAa85ChnmR" +
                                          "t3XbgYe+k+IPYNkOBSBbDRaA1Ztw4EQ+MEHY8VWYB3agyTsvJGcBB0sVxuMQ" +
                                          "MClLtM/rISoC2mA7NTT3+g8RpyjPro4cAQq477D7W8Bz2o4lyf4F8ZkIw1/4" +
                                          "+IUvbe25w458QugJMOr2ZtTtbNRtMOo2GHX7MqNCR45kg92Rjr7RNNCTCTwe" +
                                          "xMKbHp/8LPnUWx85CkzMXR1LpRxnLnhPdnMUtHv8yvG5lQaHThYQRWCv9/zX" +
                                          "wBLe9O3/zDg+GGLTDrcu4xOH2nPwc++/t/Hq72btbwDRKOSB9QBHf+CwZ17k" +
                                          "TKmLHpYkCLL7/RY+uvi3rUdO/OkWdJKDzoo7EZzhrUieyCCKntaD3bAOovxF" +
                                          "7y+OQBt3O7/j6SF032G+Dgx7fjdcpuCPH9QguE6p0+vTmTXcktHc+mPwOwLK" +
                                          "/6Yl1UT6YGP3tzV2nO+hPe9z3fjIkRA6XtiubiNp+4dTHR8WcMrAqybuB/7m" +
                                          "z79T3IK29kP4mQOTIhDC+QNhI+3sTBYgbt03GdqXU2H9/fuGv/bu77/ltZm9" +
                                          "AIqXXm7Ac2mdcgzmQDCXvPkL3t9+8xsf/OrWno0dDcG8GQmWLoKLIJvSABJF" +
                                          "t3krE8gjIXS3YYnndlEzYIoDjJ0zrGomqjvBpJ6xlmplezMvZG4FODp3BXM9" +
                                          "MJdfEN/11R/ezPzwj164xFIvFkyPd89vNJRxFYPu7z7sRW0+0ABd6fn+z5y1" +
                                          "nv8R6JEDPWaeN/CBI8cXiXGH+vjJr3/2T+566itHoa0WdNpyeKnFp9MuCJ6h" +
                                          "BmZqDcSA2H3yNZvgtzoFqrOZb0IZ/pds2Mnc+pZ9QVAOmB7f/o/v+vI7X/pN" +
                                          "wAcJHV+mNgw4OCCtfpSuGH75uXfff+Mz33p7phMQapk3PvqDLP7WsgEezeqf" +
                                          "TqvcRmPp5RNp9fK02t5V072pmiZZLKT4IOw5kg5WDFKmqauGjqGvL4C1LXem" +
                                          "Q/jp275pvv9fPraZ6g7HiUPE8lufeduPt9/xzNaBBcZLL5njD7bZLDIypm/e" +
                                          "U+XDVxsla9H65088/enffvotG65uu3i6xMFq8GNf+58vb7/vW1+8TIw+Zjm7" +
                                          "RpnWhZ1h07/yiys2vPmX2qWgg+7+KIaTS/E0PzbhXi3KtWAB41dMQZ4UzGHT" +
                                          "M0JjMnblZhSoERUkmKXyHMUpQs+me4lVzSfV3Ezu1YJggvdJIhQXU5PEfKad" +
                                          "m6IJ75EYkUOM1hxf++NFZCCWLzj6vOBL3mTieohSwPxlLicOisNlkUQkszzX" +
                                          "IlZZ2sNIqhYTu15FhnS+ZOUFrjVw7cGomDS4Nu/MctKYD80A4aVxoV5qiUnb" +
                                          "gnW/YhQRRfBr4YRwiXV3hYRzccr7PcxiTVIujRGP8vseX1rJSWg0mNU45Iy+" +
                                          "3253mWlP6cz6jJxgBu95ek3HjRWHqc3qVHdJZi14dkwRcrOp9gcDvaNOGK2D" +
                                          "R9VYyVUGZkNo9RqSWLPnQ5mD7UaeXBSpfEBbjp7LmaUmK5c9Z2p4QaEqxhw3" +
                                          "j31+jDuJ3DEsmdDhMKhg81ZoFsejjmXlHThS8njOZFGxFXhRQLRqciIllID0" +
                                          "OK5jdvmiZOUMdhagubHgNtwGYRRxuz1u1dyImEu9lUA6sD8NWkhQN2VDoLmS" +
                                          "YdSaa5uw+phKaxwbJLiLCf0BsdZHC0Gd9mQpKC1bYt+xNGnYnSKlciky8yVm" +
                                          "WKwWluXpmHHbervvGZVeSVdVrCP1xyo2shwzWefKJNnSdI2iPWcQa5xnTaer" +
                                          "WnmxqCR5bjyQx8LULoktstpbBLWJTIHgPU50wWLY0nzMDqx4RJSVtUcvHARj" +
                                          "ZalcLjO2jaLlHIE2J06H06dugSwkXI+fe7pYYuVYmdKakY/zKIqHfq+0tg2R" +
                                          "ZHvFURevjPsLRyPqzLhE4PGQXrXccIQTfJtYz1veQqcY0qIJfm4QyASrS0y7" +
                                          "1PBsB8MaVY3rVhS6jTaoSXHFiwvDriyFfryCfQJm1PUI7eny3PHaNUNoOEhV" +
                                          "ckgkWOslXFl3mL63HhaRmTkjSwMcHbbEdpUwc6Il5QtlpVC0XW66SAKU7htL" +
                                          "LecuG3PRmOcqpXxLARsnD+nEFTNpMla7PJ6Is5nG5Zc2bdMddVVbOWKN7Tkw" +
                                          "3J4kVj1XyqnDApNrugQxyjd0wgoKaFuYeuOAm/ZZLpzTXtIlZHLEUMM6PlFy" +
                                          "zXKHj/C6E7m9JCp3gFUSWM3s0dOEIQad4ogc4S1VG6PVtQ+Wz51lOZq6Naaa" +
                                          "6BM83yOb6BKrGWBNqhebKolxAyI2WVf1GUZCOuM10kwKuXZHpnBUCpEBWmaH" +
                                          "MV8w+FWL1NSC35rMVa1gLpSeNmfpRh2EqyIJG53GCB87kbfERYw1IlxbcKzi" +
                                          "BKJtU4XVFEVbVLNThUu83CuzIyRYdSu8uF4KhVkxqNQ9B6FmozYW1wf5oBt1" +
                                          "BMufDFa8auWbARE5cbdk4lhDSMS25PIcRheGam2MrRf5eb9YtUKpTXItTp/L" +
                                          "M5Rw3BVN+eoKXvXYnDeaJssqM1eGWrFazCGc3CAHBqGx3HCE1RfLfmiAgJDQ" +
                                          "jCZ562WbcoLYoZbr0ZCuuhVYXjJiBx3T1KRQnGtsTyk0UJxRtVGxaJdXzeVy" +
                                          "OVsWRB9VZYxtz8l1f4RUDbdTJTocOdZm/clspZG1BZYMnT6MzoycusrJ+EQ2" +
                                          "ZWGWH9B8ziWaphstsM66KRfWLYPuBmgTbnRmooQ40wG+FIZt2s2T1bYRtCJb" +
                                          "FcRZVEBhruzZCryM8gg6XC7zVAOLvPJ8Vh7Pc/1ebWXM1VbA5kf5ZsfzF2IR" +
                                          "60VAImVUhCuIn8eCRa9BmE2NIqerlafGCIgYVpuwh02h1ZH0VVB0J8mq3J4H" +
                                          "43Uem6MW1ZUoWyoxpG00e1Q5WXClHDHyE3UVehV5GMLV8Qx2Cz2Rkhb5nrHy" +
                                          "6FqBWxW7CG+qucggKJmS6VlMV0vwZK0QbX9tTRDf4vqYOeusFFLqMCJLRX6h" +
                                          "q+JIiPkWE+eGaoInc4m0FQ/OOzFHM5OcngTzsB05I7ait5ei6sa4RfJuEU4c" +
                                          "nx7bMzFf7DqDEa7yjMN5uYY5lEf9IVvjMAnh8UWec3MsqtKs4dRyLa6ijtna" +
                                          "WIYTox/bDbhpVprL1qA/aVMeLo1msTSaDrqrGdeqNXnG9+UmaaFqvkESkc37" +
                                          "8yGf58fdUuw3B8O+Wyu5gr0sCrUx564xv1dusUh92eOiYa9Y57qGn6tWmYqk" +
                                          "4vnGCrdxwzCDBVIPA6s4GHISTloNEI9psaos0YkyVifkZGSzSREfUyWyRYVF" +
                                          "Pa+T46nUaWlFPWoX9Royj+s6GdCOgRfz4Yrt1clOTOsOUR/POnhnnY+Vcben" +
                                          "JCY51y3Xw0xKj1q9ThFzJGbCVx07N+nJjQWuBmZRStorWInk2RLma1SlUkfr" +
                                          "jUSwRbq8mpdgmS1N2B5aCbtWn23VAnoYUoViqDXbSckqK61Zjy7rfdv2onKu" +
                                          "Zbi5Ce+yVnHZcfMcVzQmSVHpd0JKkCm22V5ZcL+tLKslU4iazbCk0Qvf0Dw8" +
                                          "9jQFMRlR57qx3uqywSJXd5WojLP1KZrrr1RPXHoVBw8IZDWVi4PQnuer8zbr" +
                                          "j3K20PbMmJ+hE5Yo8HKnEfFyM9/H0Lgs0hZdEKKcTJf5VTcoqVV8kehtr2HH" +
                                          "vMiCycQe1itK5EvjAVovzAAqmHPCQoV2V20URNFoGQRdrLLGWIudy5VoKRSp" +
                                          "6qokwJN+V+uAwFDgR+Nes0WEda+vqnwTrTbnTDsJYyRarXpYLlR5DCdoj5/D" +
                                          "5IisU0rLpQvlYaG/Ls2itmL48GJUtBN/5U99rudVRRZbczVWNnHXncFMAfXq" +
                                          "4USdVBmu2el4rMgr40m+63AoqsRztz2Dlc5Uhw2zL46M5npY6bbwSs/qMGoj" +
                                          "iZ22akyLOEq1B1JCFwrMwK5NsYIjlnmdmNdlzdPsbi82SqaBO5rKgblMlcnF" +
                                          "OoyauEKt2nhPqwGHRpBuPYbpkt2auUoTzMCypNbkysTyiSXLqjmsNDDzqCuv" +
                                          "V4Y5bsQFR2kOuVljTuO1SoyIeUsRKa0UoDWuOSBB4KCEGWV6hsjkLGSgo1x5" +
                                          "0Iw9vusUiaiJucPSEO2QlYJnkAYtBzrYJJB6h14L7cmqwMRriqu5Kpg3xcTs" +
                                          "y0mhPy7oTsSgKMk1cA8mkAEehlEHI+l5MKW4KVbC54qNdkbTEmypU1brYSpT" +
                                          "lXm9U06K3Qk382ZduCKFa0ksE1W2YZuFiCAHgdbqFspNocxi1UQsLdFqv9HD" +
                                          "Zo0GXGaXoxmlTeCl1hqVG42uJajVld+NFNGRQiGeMSAyIvlVEa4lUYhMabZq" +
                                          "VIUOFZGkzfTxOlPlCyseWVMkw8SrBseVOV9PYmZQ8OQqgxK02iI6sCmRMF2d" +
                                          "kh7rqGOSoHLTNtptKKbb92qSRNUL0oCwVhXgO6ZeVsxODh2QQ7CA4+h6YIVi" +
                                          "BWXYCjEE7mg3xSpbWHa1JT6s2+agLgRLEm6yVDdHD4VQywEvm7XLeEFwwlZT" +
                                          "K2MUWDn4wTJfJIzyksjNbCuSmKA4Y+qMOatYilmoaGxXwPz8KqhjhtpVFrKO" +
                                          "gcmiL5EFpkIoSqQEWiTBfcZOSHukyoiJNiKBkxOkWF+SFcIH+1p8Wqmb/EJa" +
                                          "MFWvMa3AgzLTRMrBjFzWcnEdFxDMbIF1mLz05uLSFm02JwlNWCAmk75aGfED" +
                                          "E7j6Gu97fr48CmHSard8rRdPq0pJ1FFNZLoOE87WCdJS3f5y3mitlMFiznBL" +
                                          "qq1xfXs6tgUvHCvIdCRzeTY066PJWuX5GOEK48WyJREE00eqCmorbaTqh+YU" +
                                          "H4dqv9jqmIPFQsg5PuV6DV+RZrTbLdmatBxQq8qshllKvwvMXgS7rlel27HO" +
                                          "T7YjvjVLXOxlt8FGOH2B/AQ7wfhqA4bQKV4IQp8XwxC6YS/dvhn9QObuyG6i" +
                                          "5NwVc4UHcoTpdvj+K2W5s63wB9/0zLPS4EP5dCuc9twEo4eO+3JLXsrWgXFP" +
                                          "g55eduVtfy9L8u+n5j7/pn+9l3619lSWm7okZUhBp9OWw/QsZe/M5MFDfB7u" +
                                          "8iO9575IPCb+6hZ0dC9Rd8nxw8WNzl+cnjsN1tqRb9N7STofeuSSXIEjylLk" +
                                          "y/vjvuwh/lMXPvP0uS3o2MHsZdrD/YdygTcqjr/grXSA3fOO06HmO6v9JwcT" +
                                          "g0CsN6WmcTcoD+8kxLP/9O3tblrfEe8b2CWWs7VnquMdO/Ghx/ZzUg3HsmQx" +
                                          "k/q5qb3IUji8YMlpfvi/zzya/9T33nF2k+CwwJNdNTzx4h3sP/8pDHrjl173" +
                                          "Hw9k3RwR0xOk/SzbPtnmWOL2/Z5R3+fXKR/xL/zl/b/+ef4DR6EjHehYoCdy" +
                                          "dk5wZGPrmYdl0LQMu5jVauZYm5x2em+k1YUQulHjA6C/7AAsI3zygEc2Quik" +
                                          "4DiWzNv73vrUi+VtDg6VPXjtxZq7A5THdjT32DVp7mJ4W/tUyL4QVlcRwjqt" +
                                          "fBBFgBCyAJDeW/tQg2uF+hAouR2ouf9HqJeo+hevgvLNafWGELpD39M0ausL" +
                                          "PkzN8hDin79WxKkrIjuIkeuu3HdeBfavpNXbQuhOPUDD0NeFKJSviPvt14r7" +
                                          "AVDKO7jL11PTv3EVyB9Iq/eE0G0HNC1JWRr3EN73XiveB0F5xQ7eV1x3PX/4" +
                                          "KqA/kla/GUK3H9Tz5VH/1rWivh+UJ3dQP3ndUf/uVVB/Kq0+DlZY+iZyXdGy" +
                                          "P3GtmF8CSnMHc/O6Y/7jq2D+bFr9YQid2cV8eS1/+hoQp6TZ0oLcQUxeT1/+" +
                                          "0lXA/llafQ6AVeVw15n3VkSHJumj+s43OBn+z18r/ntAGe7gH153jX/9KkL4" +
                                          "u7T6qxA6C4Sw59y7S9G/2If8tZ8EcgxixWU+DUhXW/dc8gnS5rMZ8ePPnjl1" +
                                          "97PTv87Ws3ufttxAQaeUyLIOnmYfuD7h+rKiZ0Bu2Cxh3ezvH0LonittRIAy" +
                                          "QZ3x/O0N9T+Bmfty1IAS1AcpvwMEdZgyhI5n/wfpvhdCp/fpQujE5uIgyQ9A" +
                                          "74Akvfxherh+YFOzYzOZ3G97MbnvNTl4Op5uhLJPwnY3LdHmo7AL4ieeJfuv" +
                                          "f6Hyoc3pvGjxSZL2coqCTm52CXsbn4ev2NtuXyfaj//olk/e8OjuJu2WDcP7" +
                                          "9nuAtwcvv37HF26YrbiTP7j791754We/kZ0Q/x9xGLNuqycAAA==");
}
