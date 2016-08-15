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
    long jlc$SourceLastModified$jl7 = 1471109864000L;
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
                                          "mb+orLpsCrfdXTpK4nhdvOLw6X8BrG9vuU8cAAA=");
    java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    long jlc$SourceLastModified$jl5 = 1471109864000L;
    java.lang.String jlc$ClassType$jl5 = ("H4sIAAAAAAAAALVaeewkWV2v+c25s8fM3uuyN8PGpZdf9X0wwFLVXV3d1dV3" +
                                          "dVV3oczWfXbdVV1duIgIQiAB1OUwwv6hEIQsR1SikaBLjBwBNRhEJQoEjYpA" +
                                          "ZP/wiKviq+rfNb85NmScTt7rOr7vve/ne733vq+e/SF03PegnGOba8W0g20p" +
                                          "DrZ1s7IdrB3J3ybIyojzfElsmpzvU+DZBeGRT5/59xfeo57dgk6w0O2cZdkB" +
                                          "F2i25U8k3zYjSSShM/tPMVNa+gF0ltS5iIPDQDNhUvOD8yR044GmAXSO3GUB" +
                                          "BizAgAU4YwFG9qlAo5slK1w20xacFfgu9EboCAmdcISUvQB6+OJOHM7jljvd" +
                                          "jDIEoIdT6T0NQGWNYw96aA/7BvMlgN+bg59+/+vP/vZR6AwLndGsacqOAJgI" +
                                          "wCAsdNNSWvKS5yOiKIksdKslSeJU8jTO1JKMbxa6zdcUiwtCT9oTUvowdCQv" +
                                          "G3NfcjcJKTYvFALb24Mna5Ip7t4dl01OAVjv2se6QdhOnwOApzXAmCdzgrTb" +
                                          "5JihWWIAPXi4xR7Gcz1AAJqeXEqBau8NdcziwAPoto3uTM5S4GngaZYCSI/b" +
                                          "IRglgO69YqeprB1OMDhFuhBA9xymG21eAaobMkGkTQLozsNkWU9AS/ce0tIB" +
                                          "/fxw8Kp3vcHqWFsZz6IkmCn/p0CjBw41mkiy5EmWIG0a3vRy8n3cXZ97+xYE" +
                                          "AeI7DxFvaH7v555/7eMPPPelDc1LLkMz5HVJCC4IH+Zv+dp9zccaR1M2Tjm2" +
                                          "r6XKvwh5Zv6jnTfnYwd43l17PaYvt3dfPjf5wuJNH5e+vwWd7kInBNsMl8CO" +
                                          "bhXspaOZkodLluRxgSR2oRskS2xm77vQSXBNapa0eTqUZV8KutAxM3t0ws7u" +
                                          "gYhk0EUqopPgWrNke/fa4QI1u44dCIJOggIdAWUMbX73pVUAXYBVeynBnMBZ" +
                                          "mmXDI89O8fuwZAU8kK0K88DqDdi3Qw+YIGx7CswBO1ClnReivYT9SIGxOABM" +
                                          "SiLlcVqACIDW304Nzbn+Q8QpyrOrI0eAAu477P4m8JyObYqSd0F4OkSx5z95" +
                                          "4Stbe+6wI58AehyMur0ZdTsbdRuMug1G3b7MqNCRI9lgd6SjbzQN9GQAjwex" +
                                          "8KbHpj9LPPn2R44CE3NWx1Ipx5kL3pPdHAXtHrtyfG6nwaGbBUQB2Os9/zU0" +
                                          "+Td/9z8zjg+G2LTDrcv4xKH2LPzsB+9tvub7WfsbQDQKOGA9wNEfOOyZFzlT" +
                                          "6qKHJQmC7H6/xY8v/23rkRN/sgWdZKGzwk4EpzkzlKYSiKKnNX83rIMof9H7" +
                                          "iyPQxt3O73h6AN13mK8Dw57fDZcp+OMHNQiuU+r0+nRmDbdkNLf+GPyOgPK/" +
                                          "aUk1kT7Y2P1tzR3ne2jP+xwnPnIkgI4Xt2vb+bT9w6mODws4ZeDVU+dDf/1n" +
                                          "3yttQVv7IfzMgUkRCOH8gbCRdnYmCxC37psM5UmpsP7uA6Nffe8P3/a6zF4A" +
                                          "xUsvN+C5tE45BnMgmEve+iX3b779rQ9/fWvPxo4GYN4MeVMTwIWfTWkAiaxZ" +
                                          "nJkJ5JEAuls3hXO7qGkwxQHGzulmLRPVnWBSz1hLtbK9mRcytwIcnbuCuR6Y" +
                                          "yy8I7/n6j26mf/SHz19iqRcLps855zcayriKQfd3H/aiDuergK783OBnzprP" +
                                          "vQB6ZEGPmecNPeDI8UVi3KE+fvKbn//ju5782lFoqw2dNm1ObHPptAuCZ6CC" +
                                          "mVoFMSB2nnjtJvitToHqbOabUIb/JRt2Mre+ZV8QpA2mx3f+w3u++u6Xfhvw" +
                                          "QUDHo9SGAQcHpDUI0xXDLz373vtvfPo778x0AkIt/ZYX7n1t2ms9G+BlWf3T" +
                                          "aZXbaCy9fDytXpFW27tqujdV0zSLhSTnB31b1MCKQcw0ddXQMfK0JbC2aGc6" +
                                          "hJ+67dvGB//5E5up7nCcOEQsvf3pd/x4+11Pbx1YYLz0kjn+YJvNIiNj+uY9" +
                                          "VT58tVGyFu1/+tRTn/2tp9624eq2i6dLDKwGP/GN//nq9ge+8+XLxOhjpr1r" +
                                          "lGld3Bk2/au8uGKDm9/SKftdZPdH0qxUjmeFiQH362GuDfMot6KL0rRojFqu" +
                                          "HujTiSO1Ql8JST9BTYVjSVbm+xbVT8xaIanl5lK/7vtTbEDggbCcGQTq0Z3c" +
                                          "DEk4l0DxXF5vL7C1N1mGet70eFtbFD3RnU4dNy8XUS/K5YRhaRSViLxoVBZq" +
                                          "yMiRNQrFWimxGrX8iCqUzQLPtoeONRyXkibb4ex5TpxwgeHnOXFSbJTbQtIx" +
                                          "Yc2r6qW8zHv1YIo7+Lq3ygcLYcZ5fdRkDEIqT/Iu6Q1crrySkkBv0qtJwOoD" +
                                          "r9Pp0bO+3J0PaClBdc51tbqG6SsWVVq1meYQ9Jp3rZjEpVZLGQyHWleZ0moX" +
                                          "C2uxnKsOjSbf7jdFoW4tRhILW80CsSyRBZ8ybS2XM8otRqq49kx3/WJNiFl2" +
                                          "EXvcBLMTqaubEq7BgV9FF+3AKE3GXdMs2HAoF7CcwSBC23dDH2/XpURMSD7f" +
                                          "Z9mu0eNKopnTmbmP5Ca803SauF7CrM6kXXdCfCH2Vzxhw97Mb+f9hiHpPMWW" +
                                          "db3eWlu4OUAVSmUZP8EclB8M8bU2XvLKrC+JfjlqCwPbVMVRb5YvV8qhUSjT" +
                                          "o1KtGFVmE9rpaJ2Bq1f7ZU1R0K44mCjo2LSNZJ2rEERb1VSScu1hrLKuOZut" +
                                          "6pXlspoU2MlQmvAzqyy0iVp/6denEgmC9yTReJNmyosJMzTjMV6R1y61tPMo" +
                                          "I4mVSoW2LASp5HCkNbW7rDZzikQxYfvcwtWEMiPF8oxS9UJcQBAs8PrltaUL" +
                                          "BNMvjXtYdTJY2ireoCdlHItH1KrtBGMM5zr4etF2lxpJEyaFcwsdz0/Rhkh3" +
                                          "yk3XslG0WVPZXlWmOkiTnJZWnLDUrWrED+IV7OEwrazHSF+TFrbbqet8087X" +
                                          "RJvI+2utjMnrLj1w16NSfm7MifIQQ0ZtoVPDjZxgioViRS6WLIedLRMfoQZ6" +
                                          "pOacqLkQ9EWuWi60ZbBxcvPduGokLdrsVCZTYT5X2UJkURbVVVb1lS3Umb4N" +
                                          "w51pYjZy5ZwyKtK5loPj40JTw02/iHT4mTvx2dmAYYMF5SY9XCLGNDlqYFM5" +
                                          "16p0uRBr2KHTT8JKF1gljtaNPjVLaHzYLY2JMdZW1AlSW3tg+dyNKuHMqdO1" +
                                          "RJtihT7RQiK0roM1qVZqKQTKDvHYYBzFo2kx352s862kmOt0JRJDxCA/RCrM" +
                                          "KOaKOrdqE6pS9NrThaIWjaXcVxcM1WyAcFUiYL3bHGMTO3QjTEAZPcTUJcvI" +
                                          "ti9YFllczRCkTba6NbjMSf0KM877q16VE9YRX5yX/GrDtfPkfNxB48aw4PfC" +
                                          "Lm960+GKU8xCy8dDO+6VDQxt8onQER2ORaniSKlP0PWysBiUamYgdgi2zWoL" +
                                          "aY7gtrOiSE9Zwas+k3PHsySq0Qt5pJZqpVyelZrEUMdVhh2N0cYyGgQ6CAgJ" +
                                          "Rauiu446pO3HNhmtxyOq5lRhKaKFLjKhyGmxtFCZvlxsIhitqONSyaqsWlEU" +
                                          "zaOi4CGKhDKdBbEejPM13enW8C5LTNT5YDpfqUR9iSYjewAjcz2nrHISNpUM" +
                                          "iZ8XhhSXc/CW4YRLtLtuScV1W6d6PtKCm925IObt2RCL+FGHcgpEraP77dBS" +
                                          "eGEeFhGYrbiWDEdhIY+MoqhANtHQrSzmlckiN+jXV/pCaftMYVxodV1vKZTQ" +
                                          "fggkUkEEuJr3Cqi/7Ddxo6WSxGy1cpU4DyKG2cGtUYtvd0Vt5ZecabKqdBb+" +
                                          "ZF1AF4hJ9kTSEss0YemtPllJlmw5h4+9RFkFblUaBXBtMoedYl8gxWWhr69c" +
                                          "ql5kV6VenjOUXKjjpERK1DymamV4upbxjrc2p3nPZAeoMe+uZELs0gJDhl6x" +
                                          "p2D5APVMOs6NlARLFiJhyS5csGOWoqc5LfEXQSe0x0xV60SC4sSYSXBOCU5s" +
                                          "j5pYc6FQ6tnDMaZwtM26uaYxksaDEVNnUTHPYcsC6+QYRKEY3a7n2mxVmTD1" +
                                          "iQQn+iC2mnDLqLai9nAw7ZAuJo7nsTieDXurOduutzja86QWYSJKoUngocV5" +
                                          "ixFX4Ca9cuy1hqOBUy87vBWV+PqEddao16+0mXwj6rPhqF9qsD3dy9VqdFVU" +
                                          "sEJzhVmYrhv+Mt8IfLM0HLEiRphNEI8poSZHyFSeKFNiOraYpIRNyDLRJoOS" +
                                          "VtCIyUzsttWSFnZKWj2/iBsa4VO2jpUKwYrpN4huTGk23pjMu1h3XYjlSa8v" +
                                          "Jwax0EzHRQ1SC9v9bgm1RXrK1WwrN+1LzSWm+EZJTDorWA6leQRzdbJabSCN" +
                                          "ZsJbAlVZLcqwxJSnTB+pBj1zwLTrPjUKyGIpUFudpGxW5Pa8T1W0gWW5YSXX" +
                                          "1p3clHMYsxR1nQLLlvRpUpIH3YDkJZJpdVYmPOjIUa1s8GGrFZRVaunpqovF" +
                                          "rirnDVrQ2F6stXuMv8w1HDmsYExjhuQGK8UVIrdqYz6eX82k0jCwFoXaosN4" +
                                          "45zFd1wj5ubIlMGLnNRthpzUKgxQJK4IlEkV+TAnURVu1fPLSg1bJlrHbVox" +
                                          "JzBgMrFGjaoceuJkiDSKc4AKZu2gWKWcVQcBUTSMfL+HVtcoYzILqRpGfIms" +
                                          "rco8PB301C4IDEVuPOm32njQcAeKwrWQWmtBd5IgzoerVR/NBQqHYjjlcguY" +
                                          "GBMNUm47VLEyKg7W5XnYkXUPXo5LVuKtvJnH9t2awKBrts5IBuY4c5guIm4j" +
                                          "mCrTGs22ul2XETh5Mi30bBZB5HjhdOaw3J1psG4MhLHeWo+qvTZW7ZtdWmkm" +
                                          "sd1R9FkJQ8jOUEyoYpEeWvUZWrSFCqfhi4akuqrV68d62dAxW1VYMJcpErFc" +
                                          "B2ELk8lVB+urdeDQ+XyvEcNU2WrPHbkFZmBJVOpSdWp6eMQwSg4tD40C4kjr" +
                                          "lW5MmnHRllsjdt5cUFi9GueFgikLpFr2kTrbGhIgcJD8nDRcXaBzZn6oIWxl" +
                                          "2IpdrmeX8LCFOqPyCOkS1aKrEzol+RrYJBBal1rznemqSMdrkq07Cpg3hcQY" +
                                          "SElxMClqdkgjCME2MRfG80MsCMIuSlALf0ayM7SMLWQL6Y5nZdhUZozaRxW6" +
                                          "JnFat5KUelN27s57cFUM1qJQwWtM0zKKIU4MfbXdK1ZafIVBa4lQjpDaoNlH" +
                                          "580mXGGi8ZxUp3CktseVZrNn8kpt5fVCWbDFgI/nNIiM+cKqBNeTMMjPKKam" +
                                          "1/guGRKERQ+wBl3jiisuvyYJmo5XTZatsJ6WxPSw6Eo1GsEppY13YUMkYKo2" +
                                          "I1zGViYETuZmHaTXlA1n4NZFkWwUxSFurqrAdwytIhvdHDIkRmABx1IN3wyE" +
                                          "KkIzVXwE3NFqCTWmGPXUCBs1LGPY4P2IgFsM2ctRIz5Qc8DL5p0KVuTtoN1S" +
                                          "KygJVg6eHxVKuF6J8NzcMkOR9ktzukEb86opG8WqyvR41Cus/AaqKz15KWko" +
                                          "mCwGIlGkq7gsh7KvhiI8oK2EsMaKlDeQZsizUpIvNSKiintgX4vNqg2DW4pL" +
                                          "uuY2Z1V4WKFb+Yo/J6J6Lm5gfB412mAdJkXuQogswWJyIt+CeXw6HSjVMTc0" +
                                          "gKuvsYHrFSrjACbMTttT+/GsJpcFDVEFumfTwXyd5NuKM4gWzfZKHi4XNBuR" +
                                          "HZUdWLOJxbvBRM7PxhJbYAKjMZ6uFY6L82xxsozaIo7Tg3xNRiy5k695gTHD" +
                                          "JoEyKLW7xnC55HO2Rzp+05PFOeX0ypYqRkNyVZ3XUQ9vROGsLoBd16vT7Vj3" +
                                          "J9sR35olLvay22AjnL7I/wQ7wfhqAwbQKY73A48TggC6YS/dvhn9QObuyG6i" +
                                          "5NwVc4UHcoTpdvj+K2W5s63wh9/89DPi8COFdCuc9twCowe28wpTiiTzwLin" +
                                          "QU8vv/K2v58l+fdTc19887/cS71GfTLLTV2SMiSh02nLUXqWsndm8uAhPg93" +
                                          "+bH+s1/GHxV+ZQs6upeou+T44eJG5y9Oz50Ga+3Qs6i9JJ0HPXJJrsAWJDH0" +
                                          "pP1xX/4Q95kLn3vq3BZ07GD2Mu3h/kO5wBtl21tyZjrA7nnH6UD17NX+k4OJ" +
                                          "QSDWm1LTuBuUh3cS4tl/+vZ2J63viPcN7BLL2doz1cmOnXjQo/s5qaZtmpKQ" +
                                          "Sf3czFpmKRyON6U0P/zfZ15W+MwP3nV2k+AwwZNdNTz+4h3sP/8pFHrTV17/" +
                                          "Hw9k3RwR0hOk/SzbPtnmWOL2/Z4Rz+PWKR/xL/zF/b/2Re5DR6EjXeiYryVS" +
                                          "dk5wZGPrmYdl0NQMu5DVSuZYm5x2eq+n1YUAulHlfKC/7AAsI3zigEc2A+gk" +
                                          "b9umxFn73vrki+VtDg6VPXjdxZq7A5RHdzT36DVp7mJ4W/tU+X0hrK4ihHVa" +
                                          "eSCKACFkASC9N/eh+tcK9SFQcjtQc/+PUC9R9S9eBeVb0+qNAXSHtqdpxNKW" +
                                          "XJCa5SHEP3+tiFNXzO8gzl935b77KrB/Oa3eEUB3aj4SBJ7Gh4F0RdzvvFbc" +
                                          "D4BS2cFduZ6a/vWrQP5QWr0vgG47oGlRzNK4h/C+/1rxPgjKK3fwvvK66/mj" +
                                          "VwH9sbT6jQC6/aCeL4/6N68V9f2gPLGD+onrjvp3roL6M2n1SbDC0jaR64qW" +
                                          "/alrxfwSUFo7mFvXHfMfXQXz59PqDwLozC7my2v5s9eAOCXNlhbEDmLievry" +
                                          "V64C9k/T6gsArCIFu868tyI6NEkf1Xa+wcnwf/Fa8d8DymgH/+i6a/ybVxHC" +
                                          "36bVXwbQWSCEPefeXYr++T7kb/wkkGMQKy7zaUC62rrnkk+QNp/NCJ985syp" +
                                          "u5+Z/VW2nt37tOUGEjolh6Z58DT7wPUJx5NkLQNyw2YJ62R/fx9A91xpIwKU" +
                                          "CeqM5+9uqP8RzNyXowaUoD5I+T0gqMOUAXQ8+z9I94MAOr1PF0AnNhcHSf4V" +
                                          "9A5I0ssfpYfrBzY1OzaTyf22F5P7XpODp+PpRij7JGx30xJuPgq7IHzqGWLw" +
                                          "huerH9mczgsmlyRpL6dI6ORml7C38Xn4ir3t9nWi89gLt3z6hpftbtJu2TC8" +
                                          "b78HeHvw8ut3bOkE2Yo7+f27f/dVH33mW9kJ8f8Bs+XZrasnAAA=");
}
