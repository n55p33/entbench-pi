class VoluntaryWaveGenerator {
    public static final int CHAN_LEFT = 1;
    public static final int CHAN_RIGHT = 2;
    public static final int CHAN_MONO = 4;
    int totalLength;
    int cyclePos;
    int cycleLength;
    int amplitude;
    int channel;
    int sampleRate;
    int volumeShift;
    byte[] waveform = new byte[32];
    public VoluntaryWaveGenerator(int waveLength, int ampl, int duty, int chan,
                                  int rate) { super();
                                              cycleLength = waveLength;
                                              amplitude = ampl;
                                              cyclePos = 0;
                                              channel = chan;
                                              sampleRate = rate; }
    public VoluntaryWaveGenerator(int rate) { super();
                                              cyclePos = 0;
                                              channel = CHAN_LEFT | CHAN_RIGHT;
                                              cycleLength = 2;
                                              totalLength = 0;
                                              sampleRate = rate;
                                              amplitude = 32; }
    public void setSampleRate(int sr) { sampleRate = sr; }
    public void setFrequency(int gbFrequency) { float frequency = (int) ((float)
                                                                           65536 /
                                                                           (float)
                                                                             (2048 -
                                                                                gbFrequency));
                                                cycleLength =
                                                  (int)
                                                    ((float)
                                                       (256.0F *
                                                          sampleRate) /
                                                       (float)
                                                         frequency);
                                                if (cycleLength ==
                                                      0)
                                                    cycleLength =
                                                      1;
    }
    public void setChannel(int chan) { channel = chan;
    }
    public void setLength(int gbLength) { if (gbLength ==
                                                -1) {
                                              totalLength =
                                                -1;
                                          }
                                          else {
                                              totalLength =
                                                (256 -
                                                   gbLength) /
                                                  4;
                                          } }
    public void setSamplePair(int address, int value) {
        waveform[address *
                   2] =
          (byte)
            ((value &
                240) >>
               4);
        waveform[address *
                   2 +
                   1] =
          (byte)
            (value &
               15);
    }
    public void setVolume(int volume) { switch (volume) {
                                            case 0:
                                                volumeShift =
                                                  5;
                                                break;
                                            case 1:
                                                volumeShift =
                                                  0;
                                                break;
                                            case 2:
                                                volumeShift =
                                                  1;
                                                break;
                                            case 3:
                                                volumeShift =
                                                  2;
                                                break;
                                        } }
    public void play(byte[] b, int length, int offset) {
        int val;
        if (totalLength !=
              0) {
            totalLength--;
            for (int r =
                   offset;
                 r <
                   offset +
                   length;
                 r++) {
                int samplePos =
                  31 *
                  cyclePos /
                  cycleLength;
                val =
                  JavaBoy.
                    unsign(
                      waveform[samplePos %
                                 32]) >>
                    volumeShift <<
                    1;
                if ((channel &
                       CHAN_LEFT) !=
                      0)
                    b[r *
                        2] +=
                      val;
                if ((channel &
                       CHAN_RIGHT) !=
                      0)
                    b[r *
                        2 +
                        1] +=
                      val;
                if ((channel &
                       CHAN_MONO) !=
                      0)
                    b[r] +=
                      val;
                cyclePos =
                  (cyclePos +
                     256) %
                    cycleLength;
            }
        }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1470933729000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1470933729000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAALV7C+zkxn3e3kmnk86S7iTHsi1b71NsadPjvncJqXGW3Bd3" +
       "ySWX5JJLJo3M5/L95pJLV3ZsILHRNI6RyInbJkJbOI8GSpwWTVu0SKGiSJMg" +
       "QYAERpsWre0GRePWNWC3aNzWbdzh7v99/7vzRfYCnOUOZ4bf95vfizPcN75a" +
       "uRRHlWrgO9u14yc3tDy5YTntG8k20OIbU7xNSVGsqagjxTEL6l5Rnv31q3/2" +
       "zU8Z1y5W7hMrb5c8z0+kxPS9mNZi39loKl65elw7dDQ3TirXcEvaSFCamA6E" +
       "m3HyEl5524muSeU6fggBAhAgAAHaQYD6x61Ap4c0L3XRsofkJXFY+XDlAl65" +
       "L1BKeEnlmdODBFIkuQfDUDsGYIT7y98cILXrnEeVp4+47znfRPjTVei1n/3h" +
       "a//gnspVsXLV9JgSjgJAJOAmYuVBV3NlLYr7qqqpYuURT9NURotMyTGLHW6x" +
       "8mhsrj0pSSPtSEhlZRpo0e6ex5J7UCm5RamS+NERPd3UHPXw1yXdkdaA62PH" +
       "XPcMR2U9IHjFBMAiXVK0wy732qanJpWnzvY44nh9BhqArpddLTH8o1vd60mg" +
       "ovLofu4cyVtDTBKZ3ho0veSn4C5J5fFbDlrKOpAUW1prrySVd51tR+0vgVYP" +
       "7ARRdkkq7zjbbDcSmKXHz8zSifn56vzlT37Im3gXd5hVTXFK/PeDTk+e6URr" +
       "uhZpnqLtOz74Iv4z0mO/+YmLlQpo/I4zjfdt/vFf/foPfN+Tb/7Ovs17zmlD" +
       "ypamJK8on5Uf/sP3oi/A95Qw7g/82Cwn/xTznfpTB1deygNgeY8djVhevHF4" +
       "8U36Xwk/8ivaVy5WrmCV+xTfSV2gR48ovhuYjhaNNU+LpERTscoDmqeiu+tY" +
       "5TI4x01P29eSuh5rCVa519lV3efvfgMR6WCIUkSXwbnp6f7heSAlxu48DyoH" +
       "n0vgeNfB+e47qSCQ4bsaFJgQFfkl9RjSvEQGYjWgUlFkfwvFkQJxAJSXSNGW" +
       "lzbaAWA/ulE2Cb4jo+Ql1mvZhQtAjO89a8QO0P+J76ha9IryWooMv/5rr/ze" +
       "xSOlPmAJrOj88SsXLuyG/Z7yPvuZAXK1gYUC3/XgC8xfmX7wE8/eA1QiyO4F" +
       "QrkImkK3dqHosU1jO8+lAMWqvPmZ7KPcR2oXKxdP+8ISG6i6UnanSg925Kmu" +
       "n7WB88a9+vEv/9nnfuZV/9gaTjnXAyO9uWdpZM+elWLkK5oK3Nbx8C8+Lf3G" +
       "K7/56vWLlXuB5QJvlUhAu4AjePLsPU4Z20uHjqvkcgkQ1v3IlZzy0qG3uZIY" +
       "kZ8d1+ym9+Hd+SNAxveX2vckON53oI677/Lq24Oy/J69OpSTdobFzjH+ZSb4" +
       "+T/+g//S3In70IdePRGVGC156YTdloNd3VnoI8c6wEaaBtr9h89QP/3pr378" +
       "B3cKAFo8d94Nr5clCuxV2mnUj/5O+G+/+IXPfv7ikdJcSEDgSmXHVPIjkhdK" +
       "TpdvQxLc7XuP8QC7d4DplFpzfem5vmrqpiQ7Wqml//fq8/Xf+G+fvLbXAwfU" +
       "HKrR9915gOP6dyOVH/m9H/7Gk7thLihl3DmW2XGzvTN7+/HI/SiStiWO/KN/" +
       "9MTf+G3p54FbBK4oNgtt510u7WRQ5h4v3Cb3iEwXzMbmwF9Drz76Rfvnvvyr" +
       "e1981rmfaax94rW/9q0bn3zt4okI+NxNQehkn30U3KnRQ/sZ+Rb4XADHn5dH" +
       "ORNlxd4LPooeuOKnj3xxEOSAzjO3g7W7xehPP/fqP/vlVz++p/Ho6QAwBPnN" +
       "r/7r//f7Nz7zpd89x1/dA4J7+aN5ptihhnaoX9yVN0qYOxlXdtdeKoun4pNO" +
       "5LS4T+RZryif+vzXHuK+9s+/vkNwOlE7aTOEFOzl9XBZPF3Sf+dZjzmRYgO0" +
       "a705/6FrzpvfBCOKYEQFZCcxGQH3nJ+ysIPWly7/u3/xLx/74B/eU7k4qlxx" +
       "fEkdSTtnVXkAeAktNoBnz4MP/MDeSLLSN1zbUa3cRH5X8fjNbgQ6sDDofDdS" +
       "ls+UxfM3G+etup4R/4W9mR/Pz+Q28zMtC3R36eWyGOyBf+Db4rhv+67dr4dv" +
       "b1KjMpc8dufv+j+kI3/sT/7XTRO9i0LnWNmZ/iL0xs89jn7/V3b9j8NB2fvJ" +
       "/OawDPLu476NX3H/58Vn7/uti5XLYuWacpDUc5KTlk5WBIlsfJjpg8T/1PXT" +
       "Sek+A3vpKNy996yZn7jt2UB0bF7gvGxdnl85E3veceiK330w8+8+qzS7bGGv" +
       "xyWkGxjIwdda9Oif/O3PfuOjH+9dLJ3fpU0JHUjl2nG7eVo+O/zYG59+4m2v" +
       "fenHd8HhUGfYvQ7uyutl8b7d/N5Tnr4fxI549xiSADqmJzk7xK2k8gA66c9f" +
       "wYcj9sg5XDvWquWdtIo8zfn94Hj8gPPj53AuT7gyASpPPng7wGXxg2XxQ4dI" +
       "r+yQ0th4ci5U6S6hltPzngOo77kN1HvLE+PuoO6FSpBz8jyk5rePdOdCypMn" +
       "DpA+cRPSyu4kOB9g5RDR2xJgqA6ueet9yn4WU3iXmB4+8IqVw+9zMGV3wHS/" +
       "slUcDTzBnAco/wsI6akDQE/dAtCH7ySkHaBbC+kjd4npKjiePsD09C0w/egd" +
       "MD0guYFjJqmqnYfox+4S0UPgeOYA0TO3QPTX74DosmIAv6855+H5ibvEU156" +
       "9gDPs7fA89N3wHMlLkWk0SClOg/Sa38BRXruANJzt4D0N++kSJvyAVtjDFNP" +
       "zsP0t+4SU6k8zx9gev4WmP7OnawtAw+s5VMUCDzP3zre7/LwfUb8+i8+9wcf" +
       "ef25/7hLwe43YxAV+9H6nLWVE32+9sYXv/JHDz3xa7vHvXtlKd7Hx7OLUjev" +
       "OZ1aStphfvBIBo+WPB4DxxcOZLD7Tiof+DbXBJgwlSLt3GWFtzrEfiJrOxnv" +
       "zzsJ4L1NtCAIKmem/e/ecdr341wAj3qXGje6N3bj/v27iz3vtBzl+uHDBqdF" +
       "McjOrltOd9f/HcnJZGK/OHcGZOvbBgkU6eHjwXDfW7/04//pU7//k899EWjM" +
       "9DB9KVvzQI+54kMf/nL545/eHZ/HSz6Mn0aKhktxQuyeOTX1iNJZ2Tv+W6CU" +
       "PDKZtGKsf/jBOQlt9pWcHqtkzeXxkcfnORw3xGmiM/2GTxDjdb2+HVCC4TOk" +
       "N2jPrOkAb23mvszwm01XajfbHYbNFiMWWUlMZvPYAF0g3DYUxqNsPNz6ywDB" +
       "+zMaqyLSeLbKpygxrdpDAzcRUhmEdH/dlOfdpA3JFDNccQlP0hbFEnANpqRq" +
       "V2yyNoLauTqf9keqPJtadJjgQhSN9MVADImtPzVkbNYwJoZs6wMK1+BalDXY" +
       "sTC34dBYq5iLLtjYnpnafMFhm9lCYEfTodQUF64tTVdBJnN5tnBDxV+7jCLG" +
       "oJ7p4MM0Wdj5YjhYGy1vvphaqcUsRYt2WQXBdDprmSuExIy01+TrOWEny2Th" +
       "dKt9fNKbmRZS09wuviToMLIarUWOiVPXNrZTJhOjbdWy5WGDm9ZE25FXzGC8" +
       "UadhtcFNkLY+4TXU8PVwEkFZO5mEXXvWXpsz38JSLxlNBtxS83t2K5SncqPB" +
       "S4QnLaL2zCRnTjYYSzYpttV5f4bT7oCOcLYxI9GqbUYBN2KdVjSI2QFRG9KO" +
       "KU6d7tBuLgxxUWcZyBvzgi+05dhDTHslhmw9WGzZHguLNcWV4YSB+D4d0r7N" +
       "iThjVbdY1mcG9EJEfHZRpyectSimU7tF2rQ/mXdDrTMlLIZ1U0/K6gGNjIRx" +
       "JEBhLsbsOFm2Gxsp9acwMvdqCWEsKUbXiIHidzpVRuBsoc95XqM7k4aeuCYz" +
       "Q8DXI6sa9fuqq9GjcXXloAuL6WZLknblTdYfrPFFjVZd33XSkEfG67XKSFMT" +
       "w7e2aU9qOTUWxsaU8QWfaGMrDbXDcTIf4gqOFQwySm2x3kgamWSKK2SEZfG6" +
       "1y361WE1ZzxeW02opPC9jboJU441OWIRI4Xt+9ue00Pofk3zrVaHnSxn7V7f" +
       "9vClqYdxBsFjWFhO171BQQkTishgTdmQjGK4c8ptEHxVKIKxGoxpUVgMsu5c" +
       "d0e5SnkS5jIWOyLmKKvrU9aGRLnOs/Vk3G8xoteOabKeFp6id7xNMVMFPUgb" +
       "I2ZiEgU94sigh5KSvagHS3tbZ6oWmixHdEDkRECEW8baWO0RExKKY4hhQinU" +
       "AHGX+dIsisCwQyhPlvN+zvpYNPOZVpA1wka0dmJnrhTjaFRlUkQW5qu2XBMa" +
       "tC1zI6zuL0N6xdVHNSybromMDidCY+0vtsEwHw1GW2KQTVkUmTRNpocJCW3w" +
       "MCeAR9WaGzeYRb3wLJ9GfUWeNIdEsobajdCb0Z1FkBNyI4O0FWTyQItrs3Uy" +
       "04bLqgJTC3NY7XK5ksOZWCOTBjkb9m2Z5OE6XK+qEmwtufUwCVoEs3YGQ0Je" +
       "SS1TAsENpwQ3n5F1h01XEw5q09P1Mq+5CYbPahhKbWUYmfRH1LCrSrlbLIcs" +
       "0NBeuCTxoeIFs9hkF7MlMh535stUJIGqyGPVjlxyHM10hMiX09xzdCh280ZP" +
       "bQ7qeXcVmMOmjs6ZttDvmUgbb03TgbOVN4rOy3AnpLRqT4dYfiUF8HrUrGLk" +
       "ZtwzDdqw5U3ubTg7R1Y4stQYa9sJ226kM0IfR6j1oo805itrpZCjAZ+L0VIU" +
       "tsOJIdQ5ErVGdXEiasWSq6lJPW3RqpxVnSwzC6xH9JuZx/MqRrVkrapG/LRt" +
       "8NZAcpfKzEp5vQvrKUQ0C73o6GER49X6ktThOsWL8UDy0C2/boVzWRblBAuM" +
       "1XjThLvdSK95sFu483VsuZuMlwlhixp9qzecZxlMdFde06oS41VW2N1BMckS" +
       "zTbQkb0lmdFgNpoHfWZkJOw80ddoKA6sRBqs5qs626dCzmBokwGqEEN1vh5N" +
       "Cj+C0pBl04XPcBGdqgQwKHXj9a1U64o43av1xg6KRcGMb+gNAplDbXhdgDmt" +
       "Cwu8vSXzaqx3ZTZzmv0AG2hGxLCxj8QCG/kEDdc3wx4saZPBwFwt12FDUIot" +
       "LiWdpBV03eYGEqhwbrCtYTsy2nCNTscbq56kemsa6MZWURsOvmEUqYVgdMZz" +
       "bg3YEdVClUmTWHV8dZxlhOw3JMudBaxD+bwttiZ5e60OSHyJ2Fy1JjeqcKtd" +
       "tNn+rOfBi62rbTUIsr1oYztFu5dn/tajWkUSFNPBYNTX8ESxVBDFIgULSSpv" +
       "qrA476ppLU+loE724IbZb26qMDcpuisNSoWCcgx9OrKNVsb5SSgiLdgpuq1a" +
       "UJtxeghFQQFMeSL0RYKb8Vy4UCU6wElXG0qEgw0Ku7HN2paGzdn5PBNoG4uE" +
       "fjUThIbXwhoRyW+8Nr22veEErRZhLg3GikJGGmVrCw9BNvrGhbf+pDmxNlNO" +
       "Q8k4aPo1hvODTTuKB2sWXlXHwHTraCz4Fr5Z85TG1fVZPmhMxgsR2MN8wHTm" +
       "EyRpiAo/Jue46cFdpaq5OFQ3GIzpmgMH5Hw2mS3IRmPhttBlnY6HidhlcLwA" +
       "hmHkdByEOLOZDYvGpo91N8NJVkjLPLLypu5hDb0nzRtGv6e0ZdfpmZugx2Jt" +
       "QUFWed5YxEUPN7uTrY1u8Xp3hjjCRgDG4vVHa9isKdWu4Bgx4fKU15lJ8WxE" +
       "EUXM9xQBJEZThVhE1LJRa2q66Zj1Vhsm6nLea1jcou9TkwUOJbE1qDch2IO2" +
       "BVafIGxXaElD3UK2bX/b6UBOnZS7iReMu2R7qDaGJC4ks5gMoJYqB0VuFv1g" +
       "wrBAmMsVSE6246CpYSSN0pYoGvOCrmsQKfWy9casrXSzaKwD1eJ5eA2c41BI" +
       "hQ7UFGIChaKxAZxeRC2kptJrDWjgBPHl2Cdqss+GCQ9DIJmZpJAWoxJRzAxn" +
       "ULeHUV2XWl2Lcb1C0RocrBO65867Fi326mljQFursNtvOXmK2pwgLzhd3iCE" +
       "4w9btoljk6BXTTK0sIgtobpdH/hamSxkRxlvSVmuWcs6cICRalJrVfdkjvcE" +
       "2IwH2Kzgx/EY4+3MnI0MDbPYpM9YU7pQdJD9N1edbUy6swWcwug0ipfLURv1" +
       "xluL9/AhtBgmXtLRogBMPyvCmjdqaRtuMdc3YHxdbLWMkZr2phqqzdfkSDRn" +
       "9sIft9DRILWmphhOtdytKtOULMyF15hSG9mAxrI8K3S3B0fDwdIStdkQ+DSs" +
       "QdWE5kqZjZ22ictLez2fTNd+Nl4Kc4aUKIRJahDLdaLWKAkjWaitAYRRuqib" +
       "SBRzcV9eiiK5tGCy2167QXuV4TLF84bc7+gKrhjBsFiaAdkPq1YcVPV5q86y" +
       "nTyER1LIjvtFM8Z7hjMcgAzDHwbBpLro62GmUWtuIMsYL2XBGhbGaNQX6XVn" +
       "TLbYGt+lq5wR2HpUAH4h7K/MJi+ZNWQzaCv2XFlLlgW3QOwGVoTA2wTBo421" +
       "lRiRqediT2Ot3KlD+rxPRFS+pXtVuA0Mdxuzq6UNbZvIeJX21upG6aByLzct" +
       "CnZFivc2wwaOWhEbaAus4LoDj/aN9tpPssXYXEDCgGoYHSjxBywP5cVsRBAm" +
       "Sqydgm8Dh7bQKc1mdU2Xx1vIa1dXdZKYseBZourCKFGF2k1RXTWpOcdP8nRs" +
       "N0aNWV4Pt01S81dE3bDXzhhK8RrcatTqXWWr1K2ZIUI1eNKCuZSCeRKFI0xD" +
       "GWWL9iZ+qkuQ3BO02B3qsJbN8i5Kd9c0z3H+yhrZWq2Qt0snYVfNoo+qVbEI" +
       "g3mL6zbVvKtaSK+aFjLkwRbI3+d21yMNXB6HUkshGMjp9fkoMxtDtBexwAc4" +
       "3WDeqWlNNp27iuBN1njONpOk3p56eGHQG1QnV4MBGYI5RpQyA+SpthI0tsms" +
       "0yIg31Wqm3bXchka7yKIOus285VPtrqjMEdHJrDLwKktx1SbF3BxAg2bwroz" +
       "o0ZDYKhIT2p7bWWQDcn5hLbdBWP4bNePBFFv0duevpn241RPHc6ppRnToxyy" +
       "rjSWHdoFadSM70G+L1dh4ETkicCT5EgdbRY+yHTNCRMWVE1HdNla1U3gEVnG" +
       "n2UgxUtggRcJR8Qb9KZI4pqVQyJT60ftuhOyURBWbWyOBQ6ymCHbOMgRUrVy" +
       "U0SWUVgjXYDRFFA+7zZheZJ3VHySm72ES0CaC+uT2theVl0r9PvVHtFKOKxL" +
       "j3mOJttoLaHHITlqShImbETfXrrdVmNtm14tls1+EvhZf2bpza1e4A5mFBjv" +
       "oW0nwvANaqfmrCNtLBRhrE5ukFs0k5v5YJslPoLUZ+Hcns6iBhpM0lrNm3US" +
       "DPPJBjqdWwgcLRiadZfmKBcXKOknyRyr2YuxNvXMZayB8KvNe9XpjKcJkGJu" +
       "SayOziN71fR6bWvChtioPp+ROXgqxUU/1qh+TaVGnuIvlepQTFdSfUCRYcsa" +
       "sJslSxhqzVyIgke4Ld+hc5Zu9329qkNbcUjCCeXpVN/LO9gETzu9qqZN1LZB" +
       "BrN+3FWrWDwS+7g7q9bTFZLzGhI3ZMdV0S6kUMKAqKdbZenOtzIKZ61YYaMe" +
       "pTrWIG+tOwWUGjUx79JeUW/h0USPnGbup4tqI3Oxxcisxs32vNcSwWMZUquK" +
       "LcgklsYc2JM8T6orxa0HvQKi9JXiaN1ukPS6EEjuqZkR1jsdUZkghoUG5nTI" +
       "oLjjG051tCpCAx6Nchbp2UB/aG895AVaxLBRtlnhRM4hcrZpblsrM69zqSj1" +
       "BJCkK8DzdJs9vRb7DszloQsvazWfCVpDIoqn6VYS5pG/7ka8rfWjzchWRdWM" +
       "V9KAbI2xGj/Vpporqr0qI+tjXFZgAhFIWRtxEbqqDqqbDd2ivGnW75dLKr91" +
       "d0s9j+yWro5eMrOcbnnhH93Fak5+q0XQo7XEo8+pt5ROrKee2BqtlBvUT9zq" +
       "RbLd3vxnP/ba6yr5C/WLBwut3aTyQOIHf8nRNppzYqjLYKQXb73qSuwWP4+3" +
       "On/7Y//1cfb7jQ/excs+T53BeXbIv0e88bvj71V+6mLlnqONz5ve8Dvd6aXT" +
       "251XIi1JI489ten5xOmd8nIRv3cg2d7ZlerjibxphnY7mO/fK8KdtsX//W22" +
       "xb9QFv8mqTwUawlztC9w7kLhxjfVY63647vZP99VfP408xfB8fIB85e/S8y/" +
       "chvmXy2L/5xUHgTMR5EWppqnbMu6Lx2T/NO3SrLcMxoekBx+l0h+4zYk/3dZ" +
       "/Pdyz0dL0ONtqBMU/8dbpXgdHNgBRey7");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("Q/HCPbemeOFSWfnnwI2U714ebUWeYPitt8qwAY7FAcPFd4bhxf1rjTuGxzSv" +
       "3obmI2Vx5aShUpIZnaZ64W1vlWrpjrgDqtx3aTLfcxuWT5TFY/vJ5HZ7gmcY" +
       "vvOtMmyCQz1gqH5nGN5zHKR/+cyMvu82XF8oi2eBYw0c6YzjufDcXb2ddMvX" +
       "bIPgnF2s/ds8+YXTgfvIXB69061PxPrnTkXo3d8BDqNpuv9DwCvK516fzj/0" +
       "9c4v7F8MVRypKMpR7scrl/fvqB5F5GduOdrhWPdNXvjmw7/+wPOH2cPDe8DH" +
       "03YC21Pnv4U5dINk995k8U/e+Q9f/qXXv7B7J+j/A8uSpdOnMQAA");
}
