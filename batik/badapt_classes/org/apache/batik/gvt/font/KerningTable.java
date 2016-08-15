package org.apache.batik.gvt.font;
public class KerningTable {
    private org.apache.batik.gvt.font.Kern[] entries;
    public KerningTable(org.apache.batik.gvt.font.Kern[] entries) { super(
                                                                      );
                                                                    this.
                                                                      entries =
                                                                      entries;
    }
    public float getKerningValue(int glyphCode1, int glyphCode2, java.lang.String glyphUnicode1,
                                 java.lang.String glyphUnicode2) {
        for (int i =
               0;
             i <
               entries.
                 length;
             i++) {
            if (entries[i].
                  matchesFirstGlyph(
                    glyphCode1,
                    glyphUnicode1) &&
                  entries[i].
                  matchesSecondGlyph(
                    glyphCode2,
                    glyphUnicode2)) {
                return entries[i].
                  getAdjustValue(
                    );
            }
        }
        return 0.0F;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1471028784000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAALVYe2wUxxmfOz/xAz94P2yMbUh55DakoYWakoBjg8kZTthY" +
                                                              "ikk49vbm7hbv7S67c/bZqfNAqqCVgigxhFSJ/ykEgghEpFFbtUmpokKipJFC" +
                                                              "aNM0CvQRtbQUFVQ1rUrb9JuZ3dvHnU2jKifd3t7MN9/M9/p93zenrqMS00CN" +
                                                              "WCUhMqxjM9ShkohomDjeroim2QtjUenpIvGvO65uXh1Epf1oako0uyXRxJ0y" +
                                                              "VuJmP2qQVZOIqoTNzRjH6YqIgU1sDIpE1tR+NEM2u9K6Iksy6dbimBL0iUYY" +
                                                              "1YmEGHIsQ3CXxYCghjCcRGAnEdb5p9vCqErS9GGHfLaLvN01QynTzl4mQbXh" +
                                                              "XeKgKGSIrAhh2SRtWQMt0zVlOKloJISzJLRLWWmpYFN4ZZ4Kml+q+eTWgVQt" +
                                                              "U8E0UVU1wsQzt2JTUwZxPIxqnNEOBafN3ehRVBRGlS5iglrD9qYCbCrApra0" +
                                                              "DhWcvhqrmXS7xsQhNqdSXaIHImihl4kuGmLaYhNhZwYO5cSSnS0GaZty0nIp" +
                                                              "80Q8tEwYe3pH7dkiVNOPamS1hx5HgkMQ2KQfFIrTMWyY6+JxHO9HdSoYuwcb" +
                                                              "sqjII5al6005qYokA+a31UIHMzo22J6OrsCOIJuRkYhm5MRLMIey/pUkFDEJ" +
                                                              "ss50ZOUSdtJxELBChoMZCRH8zlpSPCCrcYIW+FfkZGx9AAhgaVkak5SW26pY" +
                                                              "FWEA1XMXUUQ1KfSA66lJIC3RwAENguZOyJTqWhelATGJo9QjfXQRPgVUU5gi" +
                                                              "6BKCZvjJGCew0lyflVz2ub55zf5H1I1qEAXgzHEsKfT8lbCo0bdoK05gA0Mc" +
                                                              "8IVVS8OHxZmv7gsiBMQzfMSc5ntfu3nf8sZzb3CaeQVotsR2YYlEpaOxqe/O" +
                                                              "b1+yuogeo1zXTJka3yM5i7KINdOW1QFhZuY40smQPXlu6/kHHz+JrwVRRRcq" +
                                                              "lTQlkwY/qpO0tC4r2NiAVWyIBMe70BSsxtvZfBcqg/ewrGI+uiWRMDHpQsUK" +
                                                              "GyrV2H9QUQJYUBVVwLusJjT7XRdJir1ndYRQGXxRFXwbEf+wX4IeFFJaGgui" +
                                                              "JKqyqgkRQ6PymwIgTgx0mxJi4PUDgqllDHBBQTOSggh+kMLWRHKQCAlQjPAA" +
                                                              "NoBDsleMKThEXUz/PJlnqWTThgIBUPp8f8grEC0bNSWOjag0llnfcfN09C3u" +
                                                              "TjQELJ0QtBj2C/H9Qmy/EOwXovuF3PuhQIBtM53uy+0KVhmA+AaArVrS8/Cm" +
                                                              "nfuai8Ch9KFiUCklbfYkmnYHBGzkjkpn6qtHFl5e8XoQFYdRvSiRjKjQvLHO" +
                                                              "SAIiSQNW0FbFIAU5maDJlQloCjM0CccBiCbKCBaXcm0QG3ScoOkuDnaeohEp" +
                                                              "TJwlCp4fnTsy9ETfY3cFUdAL/nTLEsAtujxCITsHza3+oC/Et2bv1U/OHB7V" +
                                                              "nPD3ZBM7CeatpDI0+x3Br56otLRJfCX66mgrU/sUgGciQjgB8jX69/CgS5uN" +
                                                              "1FSWchA4oRlpUaFTto4rSMrQhpwR5qF17H06uEUlDbdZ8P2CFX/sl87O1Olz" +
                                                              "Fvdo6mc+KVgm+GqP/twv3/njF5m67aRR48r2PZi0uYCKMqtnkFTnuG2vgTHQ" +
                                                              "fXQk8tSh63u3M58FipZCG7bSZzsAFJgQ1Pz1N3Z/cOXy0UtBx88JZOpMDAqe" +
                                                              "bE5IOo4qJhESdlvsnAeATgE8oF7Tuk0F/5QTMo04Glj/qlm04pU/76/lfqDA" +
                                                              "iO1Gy2/PwBmfsx49/taOvzcyNgGJJlpHZw4ZR+9pDud1hiEO03Nkn7jY8MwF" +
                                                              "8TnIA4C9pjyCGZwGcrHuKippPPVkYiZhq3nGeajy/I/N7/z+LM84zQWIfWns" +
                                                              "xPFy6cP0+Y/5gjkFFnC6GSeEJ/ve3/U284hyChN0nCqp2gUCACcud6zNWarc" +
                                                              "TgeHLEsd4ulg2/+J2DFDjiex0NO3YUNfbyeFUisVfD6Ms2CARRMjl8sO48+3" +
                                                              "vPPYeMtvwBH6UblsAjqCbgqUIq41N05duXaxuuE0A4tiqmJLvd4aLr9E81Re" +
                                                              "TPM19PEVHimzAW0mTz2M7B6Pm833pBTWlDiodvK9L//8+LcOD3GfWTKxQnzr" +
                                                              "Zv9zixLb89t/sOjIA/ECJZdvfb9w6tm57WuvsfUOmtLVrdn8xAw6d9befTL9" +
                                                              "t2Bz6U+DqKwf1UpWE9AnKhmKUf2gVdPuDKBR8Mx7i1hesbXlssV8P5K7tvXj" +
                                                              "uFMQwDux44dDN7dYADHk6mIr7mDPpfRxJ7NMkL6GCDCVVVGxgPBT+ATg+x/6" +
                                                              "pWFFB3h41bdbJV9TrubTIThKFawmScqc1HYRQ04Dtg9aOCGM1l8ZePbqi9zm" +
                                                              "fkP5iPG+sW9+Gto/xtGUNxAteTW8ew1vIjhq0Ec3DbWFk+3CVnT+4czoD0+M" +
                                                              "7uWnqveWwx3Q7b34i3+/HTry6zcL1GNFEEf0z716NhcAQa5mO244QlOzQ8ug" +
                                                              "qZiCvT3H6zNZC+XaNZjMFgilBk8odbNQdfzyo6kHf/eD1uT6z1KY0bHG25Re" +
                                                              "9P8C0MnSiS3sP8qFPX+a27s2tfMz1FgLfBbys3yh+9SbGxZLB4OsI+QBk9dJ" +
                                                              "ehe1ecOkwsDQ+qq9nmBp4cHCrMcjhT6WMcdh/+/K2QExOyBGiyeZS9JHDEJL" +
                                                              "oobmfjEJ+a68UZrRFxSuFTrSOmHZfeT7s7675vj4ZVbW6FlUwFumezMwj6f7" +
                                                              "v1HzowP1RZ3gJF2oPKPKuzO4K+5VVJmZiblSstMXO2qzIoviA0GBpXACNrxy" +
                                                              "EjnZ4CLTXU17/ch1wxKVDly6Ud1347WbeQDvLR67Rb3NAb3FNNRn+budjaKZ" +
                                                              "Arp7zm1+qFY5d4vl0UpRgqRnbjGg1cp6Sk2LuqTsVz95febOd4tQsBNVKJoY" +
                                                              "7xRZ1Y6mQLmMzRR0aVn93vt4DTJEq5JaJirKEz7fvnQgbWHFPMte9L09V+XQ" +
                                                              "AgfNg2+TVeU0+YtuC95HC8M71LhluiEPAk77itzKSZgS2rkTQ+bevZrX9fTJ" +
                                                              "0O1RzmmokNBZV+zk9mOfUuTr3N1FtaMARE3XMNHlCkPoo3vGxuNbjq0IWg61" +
                                                              "jYAtNP1OBQ9iJU+XO3LHqLNFXWUdY5Vfl46gPglybcFES33+XswOUGwWrpd9" +
                                                              "qe3uyE5pX2vkY1ueVTym6LPHH870r86mxuysUetkFH4bRscPM5qDk4ThM/Tx" +
                                                              "JERREhPrsoCVJoz4KSth0p+I672XFgoQBKTwuRwf2T+Jj/zvgUFQlfseg+Lh" +
                                                              "7LzbUX6jJ50erymfNb7tfV7q2rduVZC/EhlFcVdJrvdS3cAJmemjisMHV+7z" +
                                                              "BM2ZsMAlqJj+sFMf4/QvQPIuRA8lATzdlKfAYH5KUCr7ddOdIajCoYMCi7+4" +
                                                              "Sc4CdyChry/rBbyBl5XZgDe6ciaacTsTuQKyxQPV7B7bduoMv8mOSmfGN21+" +
                                                              "5OaXjvEGX1LEkRHKpRLyCL9ryKX4hRNys3mVblxya+pLUxbZIVHHD+zE5zyX" +
                                                              "J6fB/3TqG3N93a/ZmmuCPzi65rWf7Su9CKC/HQVEqMO25xfgWT0D2LM9nJ8v" +
                                                              "oRxibXnbkm8Pr12e+MuHLN2ivMbGTx+VLh1/+L2Ds49C+17ZhUoAvXCWdQb3" +
                                                              "D6tbsTRo9KNq2ezIwhGBCxR9nmQ8lbqxSGOa6cVSZ3VulF4PEdScXwbnX6pB" +
                                                              "6hrCxnoto8atdF7pjHgu2K3QqMjoum+BM+LqCzUOD9Qa4I/RcLeu291C6XSd" +
                                                              "RbI+MYqdZ6/0ceG/nEOR1eMaAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAALU6acwrV3XzvrfmJeS9BEhCIPsLJRn6zXgb2wpL7LHH69ie" +
       "1faU8ph9xp59scdDUwISBRWJohJoWkH+NJQWhaVVUStVVKmqFhAICYS6SSW0" +
       "qlTaFIn8KK1KW3pn/O1voaiqJV/P3HvuuWc/597rF74PnQ0DCPZca6NbbrSr" +
       "JtHuwqrsRhtPDXf7w8pEDEJVwS0xDFnQd1V++AuXfvijjxiXd6BzAvRq0XHc" +
       "SIxM1wlpNXStlaoMoUuHvW1LtcMIujxciCsRiSPTQoZmGD0xhG49MjWCrgz3" +
       "SUAACQggAclJQBqHUGDSq1QntvFshuhEoQ/9InRqCJ3z5Iy8CHroOBJPDER7" +
       "D80k5wBguJC984CpfHISQA8e8L7l+RqGPwYjz/zaOy//3mnokgBdMh0mI0cG" +
       "RERgEQG6zVZtSQ3ChqKoigDd4aiqwqiBKVpmmtMtQHeGpu6IURyoB0LKOmNP" +
       "DfI1DyV3m5zxFsRy5AYH7Gmmain7b2c1S9QBr3cd8rrlkMj6AYMXTUBYoImy" +
       "uj/lzNJ0lAh64OSMAx6vDAAAmHreViPDPVjqjCOCDujOre4s0dERJgpMRweg" +
       "Z90YrBJB994QaSZrT5SXoq5ejaB7TsJNtkMA6pZcENmUCHrtSbAcE9DSvSe0" +
       "dEQ/3x+95cPvdrrOTk6zospWRv8FMOn+E5NoVVMD1ZHV7cTbHh9+XLzrSx/c" +
       "gSAA/NoTwFuYP/iFV5588/0vfmUL8/rrwIylhSpHV+Xnpdu/+Qb8sfrpjIwL" +
       "nhuamfKPcZ6b/2Rv5InEA5531wHGbHB3f/BF+s/nT39GfXkHutiDzsmuFdvA" +
       "ju6QXdszLTXoqI4aiJGq9KBbVEfB8/EedB48D01H3faONS1Uox50xsq7zrn5" +
       "OxCRBlBkIjoPnk1Hc/efPTEy8ufEgyDoPPhCt4Hv/dD2k/9G0BwxXFtFRFl0" +
       "TMdFJoGb8R8iqhNJQLYGIgGrXyKhGwfABBE30BER2IGh7g3oqwjRgGCQgRoA" +
       "DDorSpa6m5mY9/+JPMk4u7w+dQoI/Q0nXd4C3tJ1LUUNrsrPxM32K5+7+rWd" +
       "AxfYk0kEvRGst7tdbzdfbxest5utt3t0PejUqXyZ12TrbvUKtLIE/g0i322P" +
       "MT/ff9cHHz4NDMpbnwEizUCRGwdg/DAi9PK4JwOzhF58dv1e/j3oDrRzPJJm" +
       "tIKui9n0SRb/DuLclZMedD28lz7wvR9+/uNPuYe+dCw077n4tTMzF334pFQD" +
       "V1YVEPQO0T/+oPjFq1966soOdAb4PYh1kQhsE4SR+0+uccxVn9gPexkvZwHD" +
       "mhvYopUN7ceqi5ERuOvDnlzdt+fPdwAZ35rZ7t3g+6Y9Y85/s9FXe1n7mq15" +
       "ZEo7wUUeVt/KeJ/8q2/8UykX934EvnQkpzFq9MQRr8+QXcr9+45DG2ADVQVw" +
       "f/vs5KMf+/4Hfi43AADxyPUWvJK1OPB2oEIg5vd/xf/rl77z/Ld3Do0mAmkv" +
       "lixTTg6YzPqhizdhEqz2xkN6QNSwgHNlVnOFc2xXMTUzM9/MSv/z0qOFL/7L" +
       "hy9v7cACPftm9OafjOCw/3VN6OmvvfPf7s/RnJKzrHUos0OwbSh89SHmRhCI" +
       "m4yO5L3fuu/Xvyx+EgRVEMhCM1Xz2HTqwHEevbHj5Ei2Ufy533rkG+957pG/" +
       "A3QI0AUzBPm/EejXSStH5vzghZde/tar7vtcbqtnJDHM48DFk/n42nR7LIvm" +
       "dnXbgYqyeApdBt8H91T04Ek7zEFfCzzi5rEmB9s9JorHbiwKIqP40A3v+Y+x" +
       "Jb3v7/89V8s10eM6ifPEfAF54RP34m97OZ9/6MbZ7PuTa8MrkPbh3OJn7H/d" +
       "efjcn+1A5wXosrxXyvGiFWfOIQB5hvv1HSj3jo0fL0W2efeJgzD1hpMh5Miy" +
       "JwPIYVgHzxl0rtptzMiaUnIKyvXxlnzGQ3l7JWt+Jhf3Tvb4pgggNR3R2vPA" +
       "H4PPKfD97+ybqTXr2ObMO/G9xP3gQeb2QD45Z6mOHhk3190kMG0QVFZ7RQvy" +
       "1J0vLT/xvc9uC5KTijoBrH7wmV/+8e6Hn9k5UgY+ck0ldnTOthTMJfGqrHky" +
       "AdQ9dLNV8hnEP37+qT/67ac+sKXqzuNFTRvU7J/9i//6+u6z3/3qdbLqaeBB" +
       "2UvRSw6semcr5n1n2IaGTO2g8HMdNYsy+2PbLGu6uwdFNxhMruMfj99YxmTu" +
       "sYdG+uX3/fO97NuMd/0U6fWBEzI6ifJ3yBe+2nmj/Ks70OkDk72mIj8+6Ynj" +
       "hnoxUMEWwmGPmet9W3PN5be11ax5NFdd/v74gSSgXBJQDju9ydg8a1hg3HIm" +
       "6q1mbgL+jmT7i9wE5p1Z80B4tAg5roMju7yr8ke+/YNX8T/441euCU/Hcy4p" +
       "ek8cuuyDmaHefbLi6oqhAeDKL47ecdl68Ud5/L9VlEGwDscBKPeSYxl6D/rs" +
       "+b/5kz+9613fPA3tENBFyxUVQsyLHegWUGWooQEqxcR7+5PbCL6+sBfSoQS6" +
       "hvmtHd6Tv53Jn6vHc8Hrb5YL9oKQfv0gBEqA815grkA0ycXwZJRtAMAGbesa" +
       "xW1Fk7VXs8bY0iLdkO7q1t9PAbxni7vVXTR7d6+/9um9AHguzDfD2dvb94m4" +
       "e2HJV/YDHg92xkB1VxZWdd9hLx8683Y7eYLQJ//XhAKN336IbOiCnemH/uEj" +
       "X/+VR14Ciu5DZ1dZ1gAqPrLiKM4267/0wsfuu/WZ734or6eAJPmnH3356Qzr" +
       "5mbsZk14jNV7M1aZfDMyFMOIzEsgVTngFj/CTycChZT7f+A2uv35bjnsNfY/" +
       "Q36uFtdcktjaOEWSRlovT4obUuKMSqUlLt35FDTNhV5bCmxkzM3lslxfSXbV" +
       "kFZVBqvKiCT42qjh+zivm3piEEwf2Szbum60PYKQIs723OXA9PoELo5IFF9R" +
       "dCRRHMFThYALpHo/FkrKqutwxcXA1JRSVCVHdYSsI169lKpO4JMMiuKjKc4Z" +
       "pJ8syDpjLF2wvWst1MA17SIVLTjV8XqrzmqMVeKZUWh7WsEFRKPxZkYnfXTD" +
       "x317UvQpXhj3fJcdpfSii839ns4VwlbPaxciGh61yWJcH2C9ZbjBFMm0m0PU" +
       "5Obzwtxud7q9kCrhs2SO68YCl+lOw2krUsWrr3C/HTD1TqerDcXhaoQWqI3D" +
       "plbZpqSZMVMH+qDD9IKGYRQZOppSZISmvDUeWG6/x6T9IT2cTm1vTozKglAe" +
       "2Bbswyo71Xkq4mptlOO5wjqk0qjYZ7m1kEx6ie+M2uOmqI1KqkHzTbpjMRVT" +
       "t4JW3Z/jEh40vEBEW8ZUXhl+YM+YahJSxshXmJnY6/Zs07DKy7hjD8W5MTKE" +
       "9XxckRnGYdCOKEQb1Ol5NZSqRe31XC153aqyNPnReCLaTMFIKl19SVLFAaUR" +
       "vYAlp5s5BveT7rjeVRh3Hq9lKfQXvV5FtDAUrfhzd9mAxVKB63XJ1C0W+9g4" +
       "CPFxrx/Ty7lhV0h6SPbUDeJxS6LV7odhBRXGHKNE/aQ9bOKGSwo43a2llsdM" +
       "cDyQ570pTGhLoZPUGw1DF/mluKww0yIGxDdtNwozcsZxVGGgMQ0Ms/o9vESv" +
       "G+2RHgvjTZ/1p4ZqNdhO361TC21G0ROd57iKbmLNAS6sFv0Orq5Ra6NZfFqM" +
       "pUol1SrdQq/gtxszPe22w4HG1iwJd1FJcQdoRW+gpFzr8TxTG3cTwV5V9dBs" +
       "klSqkYxccSItLjlaLRRSqYSLKsW7UUgX53Or7YnjxFdB2VmAN7Grq24hnbH9" +
       "pVjakBWzOuiNlPG0QBGGEM/LaGhTk5kVY8iy203hfrDmaZqWfYulrOV6jvje" +
       "GI3wclAcmQ1+uuk1SbWKNpkwiVaC1pR9HVHXQacHx+aUJltdjwq5QWcT8MVu" +
       "neKo/pxr8vx6GIf9BVud0UrfDAqOMqepziyhidlaamvwelbuqQTRFzt6bPYH" +
       "/sbXlzSFTTb2uqezeoLaSd8sT7iW7ltWq9tsUuyYAb4PL8nhlO4OKLxhUYtJ" +
       "ozFym63QUskBa7RnXIpM+pbjT1nW0HtNbuLVtJoetHFUGjHT8ULUUctyNFkb" +
       "oXW8FLMLqj3so1TUXBRxBBBvb5D2eD1zVzFRmsQG1WtGZKUUb2B0wBt2A26I" +
       "jYAPmBqC244Wi2YNN+oDwuTwpSVp86XtzLvNTrpcLD0H86MuYVXU2syliLlC" +
       "rxiTXgwW1GrYHTONnslQoylKSESvwVVssdW3KMvFFyCOyXLTxKUB3hRnso1S" +
       "nRIju+Nl3HJE1QWhj+2vLdwraw4bbuptVpuXZIJTGkPEYYftsBHFiwTvsWE3" +
       "FUuwiyPtqCitChwy7jarvDNplYQmWcVVMfJaPRROSs2ggrnRkO5r+AzDbD3g" +
       "kJDTO7JJLfRmbTHD6giuM5V4VCCYqWw0yi5teZxIsJFbDhgyoAxvTVd8olDt" +
       "oljc5qyWpAi1SREnZkho1arjwthKiZXiYrYMD3jdhjv+BInWqxLiLIiKjVVF" +
       "mi7XguJEMNF4jg9IP3KWBOvEneJKZ7sU8KllLWIMrBSXyEqNMD0B71QlRkjD" +
       "BtHXqcIkLYxKAiKPZxuUi5pJrdYXxh7Zaviq1K70xm7Z7xttRrFWodNQG6ze" +
       "rrlElY2XKIFUKJZ00XLHWiC+ZaNlj0OqGGJpfqthjgudTRGZrJu2FiblOhKJ" +
       "41Uqb0Z6p9+3vK6wLgs0XPdasVIwzPYYLY2WTnUxr5FrosY6vUYZr3uLDd4R" +
       "1h056MYgU3mTCb+cm4Lhl5yOKi42SA8ZVZEUHpK1ckpNe9rUCZMJscHkCQrP" +
       "kYq+WBKEg2MdRm33kZVaQrhirWxscGOEOrjvFXUOb+ByrGDpaCoGMqurXWAE" +
       "Sjm29CIC94storUw1QQdjUtzbqRJG5XgzJDXWhgZFvEGTZMLqxaOyzW4tJpM" +
       "5ioZrdbNLsZJVthY+Lik+1zPLxdGaEWJZ2ISx220UY5M3+4PV0pZHAb1dq1A" +
       "q+yELNQnbb5r2mljitpsWiSrTWxi10olr8lOrZbpKqtBfYggNXgoj1uljjZl" +
       "BwnlpIGwqqdmMpRq9QgJx4teA2njfUFZaVJ9jUV2pTqNV6HGje1oyAeKU0sa" +
       "a0ypS6rGDutRsZliHNzyB2utwHnTdr3hDAx7wGlFnVcmcWvQpGtkUjULhhpK" +
       "MysM+dqkMqhGq9kiJkhq3YqTcllpjarKvNHqLjG7F1Tt1sTTQHqvjsjlEOvg" +
       "LZzn+U6iT5osDKwHThDMmxJEs2SUC5Ii9fk6G8QS22ONASGubUb25UIXBDu0" +
       "3Ir0ujjGO2TBqgnqRPLNempry0nFnHTgcFqHO5GLJFGHGyWNCKTnmrourHoL" +
       "w0fbcqklTYklXMJ5h4XLcuq2UJisxlPHX6nTdVKiqlKpbJZgpMsGGyyVh4XO" +
       "iGi3NTStFrCRITcosWKPi+UyZY1TqhbrvmDiK7bUBaYi4PBMHAkLktBNq7ms" +
       "uYo0ohQt3bjYsqshaqsQs1haGMxRqdspVmi1PqnhKOkwJlMKJzWfmMxgsVgN" +
       "i5FGpgVCH2pNaROWNgZcZ6ROIgyb5XHYg6nmsq70VUMtqPJ4uQ5bFOz7dcdu" +
       "emW5iwekvDBYbErKioHAyKBItZPxptkxN6rA1PtdkLqHrivZ2qLdh0WsxgkB" +
       "TSRMTLABM7a7gqay1bCKVSurRVngpSlGWNyaiG01JdcLTKuuCt3UXU8KtFDS" +
       "+0TRnQwmgzgdlwdwhef7tmBKFgNK4tm46Kc9d2U20E7TmzXwUZBs2gtHKOND" +
       "dsYVqohsFNbJgG9ZG4xTCqVydSqpVGs1pLEqLZVGDalEjEa0A0uxshAHQiPw" +
       "qqldgH1iXlHKKwvlPFr3aUdadPSC7GHMsjiMfTbk03pFU6WxUo6osDniB313" +
       "Xk1ooTDHbGpokylNoyLv1EurqNxi+22/0hdBIh2006q2cihdmnaJCRmp9SFa" +
       "5+EZ1dC1kV6EWV7lQOyIYrxe6eI1sloYGlZstieNZbVqRumAEXSmGCxZCpbU" +
       "lRDM6hrbR8cFOrVtdzlqCjycLuv2WONiNiiBqB+JZINul2bkqGvhy4nrllad" +
       "JB5JCx/tTXWssJg3otGkMG5SdbPPwbNxadj1hyNiNuWUeYXXrDKmT3RrI8lE" +
       "mymV4Fm4HnOd9TTwlLqvgtzarniz4mo5L8Qqz25sbDjpdmtVNKhhdhJvQk6N" +
       "lkS3LNGhPCErfmtZZg0SYZN+m6bbxiQIXZzvu2l5wEQG6sE9rFqcEbpLNQfs" +
       "OqbXWpGF+wskXekcQVlaqOrw0KgOU4mbYYt+BVWDja2NpGqk8VW/GCgxL4Ck" +
       "aViEzCv9YKUwJbnRt1V7YYZkl4eraZMsCiHZsPz+Ag4JUisj1Iqa9GK6UQN1" +
       "YKpYA60x71YGHB5UFWWs9MQF7s5J3KzCZUYu4wqI3sEGCYDLNK3KTNBbKiab" +
       "oiizIRtTg01CTfhqsyopsUuuavaYsbXOqFiAK2Nxtli1O7PCsL0EBZBHDzf4" +
       "sB5sBrOyQY+A/9m8ZCUbEfaGXCIJPb7bbcFpu5JuZn1MayIl1u+URvWSiAi2" +
       "HeOT1MQqwVSrMnEdH4Dqh+LbPjkuVhJNn7Joqzgk606/tnLpxJRmjrS0a5Og" +
       "UFRhMu4OR0VzRUodNoH5oVFA4GGxFZbrOFyoCgbnNlYzfKpQUqmFRVLI0m59" +
       "MPKLatpbG50mntAgBlCg5vUTpjMWMZlnhBIfW0R50lYYGZSHzgzzmpgR4Inj" +
       "Rm5NjBSi6i26elwclCifXLixDTdJeOjjKTdu1Smx3ENoeajGxXoBx2aMQks9" +
       "mJz7ioAhqKx2EKc9pgsqKYJd6Vuz7er7f7pt9B35icHBbTTYPWcD8U+xU06O" +
       "nH0dHLDkn3PQiRvMo/chh4czUHZ8dN+NLpnzM87n3/fMc8r4U4WdvUOtbgTd" +
       "Ernez1rqSrWOoDqVP1MHZNyxf7ZT2yOjdvKc55DRaw95cpEl1zvPO7M9Vcpe" +
       "iYMmF1qcwz97kwO538iaj0bQJV2N9q4u8yP2651anNUsV4wO9fDMTzqxOHYA" +
       "FkG3Hb0bzS567rnmHxfbfwnIn3vu0oW7n+P+cnvlsn+Tf8sQuqDFYFtx5Mz+" +
       "yPM5L1A1M+fqlu1xoJf/PB9Br7vhHUoEncl+cnJ/cwv/6Qh6zfXgI+g0aI9C" +
       "fiaCLp+EBGLKf4/CfTaCLh7CRdC57cNRkC8A7AAke/xd7zoHZNtLjuTUcUs9" +
       "UMWdP0kVR4z7kWNHr/l/Y/aPquPtv2Ouyp9/rj969yvYp7b3nLIlpmmG5cIQ" +
       "Or+9cj047n7ohtj2cZ3rPvaj279wy6P77nL7luBDWz9C2wPXv1Rs216UXwOm" +
       "f3j377/l0899Jz+v+x88WjdPtCQAAA==");
}
