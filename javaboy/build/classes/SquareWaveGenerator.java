class SquareWaveGenerator {
    public static final int CHAN_LEFT = 1;
    public static final int CHAN_RIGHT = 2;
    public static final int CHAN_MONO = 4;
    int totalLength;
    int cyclePos;
    int cycleLength;
    int amplitude;
    int dutyCycle;
    int channel;
    int sampleRate;
    int initialEnvelope;
    int numStepsEnvelope;
    boolean increaseEnvelope;
    int counterEnvelope;
    int gbFrequency;
    int timeSweep;
    int numSweep;
    boolean decreaseSweep;
    int counterSweep;
    public SquareWaveGenerator(int waveLength, int ampl, int duty, int chan,
                               int rate) { super();
                                           cycleLength = waveLength;
                                           amplitude = ampl;
                                           cyclePos = 0;
                                           dutyCycle = duty;
                                           channel = chan;
                                           sampleRate = rate; }
    public SquareWaveGenerator(int rate) { super();
                                           dutyCycle = 4;
                                           cyclePos = 0;
                                           channel = CHAN_LEFT | CHAN_RIGHT;
                                           cycleLength = 2;
                                           totalLength = 0;
                                           sampleRate = rate;
                                           amplitude = 32;
                                           counterSweep = 0; }
    public void setSampleRate(int sr) { sampleRate = sr; }
    public void setDutyCycle(int duty) { switch (duty) { case 0: dutyCycle =
                                                                   1;
                                                                 break; case 1:
                                                             dutyCycle =
                                                               2;
                                                             break;
                                                         case 2:
                                                             dutyCycle =
                                                               4;
                                                             break;
                                                         case 3:
                                                             dutyCycle =
                                                               6;
                                                             break; } }
    public void setFrequency(int gbFrequency) { try { float frequency = 131072 /
                                                        2048;
                                                      if (gbFrequency != 2048) {
                                                          frequency =
                                                            (float)
                                                              131072 /
                                                              (float)
                                                                (2048 -
                                                                   gbFrequency);
                                                      }
                                                      this.gbFrequency = gbFrequency;
                                                      if (frequency != 0) {
                                                          cycleLength =
                                                            256 *
                                                              sampleRate /
                                                              (int)
                                                                frequency;
                                                      }
                                                      else {
                                                          cycleLength =
                                                            65535;
                                                      }
                                                      if (cycleLength == 0)
                                                          cycleLength =
                                                            1; }
                                                catch (java.lang.ArithmeticException e) {
                                                    
                                                } }
    public void setChannel(int chan) { channel = chan; }
    public void setEnvelope(int initialValue, int numSteps, boolean increase) {
        initialEnvelope =
          initialValue;
        numStepsEnvelope =
          numSteps;
        increaseEnvelope =
          increase;
        amplitude =
          initialValue *
            2;
    }
    public void setSweep(int time, int num, boolean decrease) { timeSweep =
                                                                  (time +
                                                                     1) /
                                                                    2;
                                                                numSweep =
                                                                  num;
                                                                decreaseSweep =
                                                                  decrease;
                                                                counterSweep =
                                                                  0;
    }
    public void setLength(int gbLength) { if (gbLength == -1) { totalLength =
                                                                  -1;
                                          }
                                          else {
                                              totalLength =
                                                (64 -
                                                   gbLength) /
                                                  4;
                                          } }
    public void setLength3(int gbLength) { if (gbLength == -1) { totalLength =
                                                                   -1;
                                           }
                                           else {
                                               totalLength =
                                                 (256 -
                                                    gbLength) /
                                                   4;
                                           } }
    public void setVolume3(int volume) { switch (volume) { case 0:
                                                               amplitude =
                                                                 0;
                                                               break;
                                                           case 1:
                                                               amplitude =
                                                                 32;
                                                               break;
                                                           case 2:
                                                               amplitude =
                                                                 16;
                                                               break;
                                                           case 3:
                                                               amplitude =
                                                                 8;
                                                               break;
                                         } }
    public void play(byte[] b, int length, int offset) { int val =
                                                           0;
                                                         if (totalLength !=
                                                               0) {
                                                             totalLength--;
                                                             if (timeSweep !=
                                                                   0) {
                                                                 counterSweep++;
                                                                 if (counterSweep >
                                                                       timeSweep) {
                                                                     if (decreaseSweep) {
                                                                         setFrequency(
                                                                           gbFrequency -
                                                                             (gbFrequency >>
                                                                                numSweep));
                                                                     }
                                                                     else {
                                                                         setFrequency(
                                                                           gbFrequency +
                                                                             (gbFrequency >>
                                                                                numSweep));
                                                                     }
                                                                     counterSweep =
                                                                       0;
                                                                 }
                                                             }
                                                             counterEnvelope++;
                                                             if (numStepsEnvelope !=
                                                                   0) {
                                                                 if (counterEnvelope %
                                                                       numStepsEnvelope ==
                                                                       0 &&
                                                                       amplitude >
                                                                       0) {
                                                                     if (!increaseEnvelope) {
                                                                         if (amplitude >
                                                                               0)
                                                                             amplitude -=
                                                                               2;
                                                                     }
                                                                     else {
                                                                         if (amplitude <
                                                                               16)
                                                                             amplitude +=
                                                                               2;
                                                                     }
                                                                 }
                                                             }
                                                             for (int r =
                                                                    offset;
                                                                  r <
                                                                    offset +
                                                                    length;
                                                                  r++) {
                                                                 if (cycleLength !=
                                                                       0) {
                                                                     if (8 *
                                                                           cyclePos /
                                                                           cycleLength >=
                                                                           dutyCycle) {
                                                                         val =
                                                                           amplitude;
                                                                     }
                                                                     else {
                                                                         val =
                                                                           -amplitude;
                                                                     }
                                                                 }
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
      ("H4sIAAAAAAAAALVaC3AV1Rk+9+ZBSAh58BQIrwQV1FxREDGKQkgkeEnSBJEG" +
       "JWz2niQLe3eX3XOTGxRFOwh9yFgNaltlHMWiDIp16mCnVWgdwVd1RNtqHcFa" +
       "R20trUyrdmpb+/9n997du3d3401NZvZk79nzn/P93/n//zwPnCIFhk6mU4XV" +
       "sgGNGrUNCmsVdIPG6mXBMFZDXqd4d57w9/UfNS8Ok8IOMrZXMFaJgkEbJSrH" +
       "jA5SJSkGExSRGs2UxlCiVacG1fsEJqlKB5kgGU1xTZZEia1SYxQLrBH0KKkQ" +
       "GNOlrgSjTVYFjFRFAUmEI4ksdX+ui5IxoqoN2MUnO4rXO75gybjdlsFIeXSj" +
       "0CdEEkySI1HJYHVJnZyjqfJAj6yyWppktRvlhRYFK6MLsyiY/XjZZ1/c3lvO" +
       "KRgnKIrKuHpGGzVUuY/GoqTMzm2QadzYTG4keVFS4ijMSE001WgEGo1Aoylt" +
       "7VKAvpQqiXi9ytVhqZoKNREBMTIrsxJN0IW4VU0rxww1FDFLdy4M2s5Ma2tq" +
       "maXi7nMig3evL38ij5R1kDJJaUc4IoBg0EgHEErjXVQ3lsZiNNZBKhTo7Haq" +
       "S4IsbbF6utKQehSBJaD7U7RgZkKjOm/T5gr6EXTTEyJT9bR63dygrF8F3bLQ" +
       "A7pOtHU1NWzEfFCwWAJgercAdmeJ5G+SlBgjM9wSaR1rroICIDoqTlmvmm4q" +
       "XxEgg1SaJiILSk+kHUxP6YGiBSoYoM7IFN9KkWtNEDcJPbQTLdJVrtX8BKVG" +
       "cyJQhJEJ7mK8JuilKa5ecvTPqeZLd12vrFDCJASYY1SUEX8JCE13CbXRbqpT" +
       "8ANTcMy86F3CxKd3hgmBwhNchc0yh244fcW50488b5aZ6lGmpWsjFVmnuLdr" +
       "7GvT6ucuzkMYRZpqSNj5GZpzL2u1vtQlNYgwE9M14sfa1McjbUe/uW0//ThM" +
       "iptIoajKiTjYUYWoxjVJpvqVVKG6wGisiYymSqyef28io+A9KinUzG3p7jYo" +
       "ayL5Ms8qVPlvoKgbqkCKiuFdUrrV1LsmsF7+ntSI9VcAT8R65/8ZuTzSq8Zp" +
       "RJMirbqKqhsRCDZdQGtvBA2lSx2IGLoYad+cEHR6jdBHLbSqXovftf+/iiSi" +
       "HNcfCgGB09zuK4Plr1DlGNU7xcHEsobTj3W+ZJoGmrOlHyPjPConoRCvczw2" +
       "YnYI0LkJHBMi45i57det3LBzdh5YgtafD1yEoejsjBGi3vbeVMjtFA9Wlm6Z" +
       "dWL+s2GSHyWVgsgSgowBf6neA6FE3GR525guGDvsED7TEcJx7NFVkcYggviF" +
       "cquWIrWP6pjPyHhHDakBBl0p4h/ePfGTI/f037zmpvPDJJwZtbHJAgg4KN6K" +
       "sTYdU2vc3upVb9mOjz47eNdW1fbbjGEgNXplSaIOs9297qanU5w3U3iy8+mt" +
       "NZz20RBXmQB+ACFruruNjLBQlwqxqEsRKNyt6nFBxk8pjotZr6722zncHCv4" +
       "+3gwiyL0k6nwbLQch//HrxM1TCeZ5ot25tKCh/DL2rX73nzlTxdyulPRvswx" +
       "TLdTVueIMFhZJY8lFbbZrtYphXLv3NN65+5TO9Zxm4US1V4N1mBaD5FF4E6w" +
       "/fnNb508sfeNcNrOQwyG2EQXzFSSaSVDqNOoACWhtTNtPBChZPBztJqaqxWw" +
       "T6lbErpkio7177I585/8y65y0w5kyEmZ0blDV2Dnn7GMbHtp/efTeTUhEUdI" +
       "mzO7mBl2x9k1L9V1YQBxJG8+XvWDY8J9EMAhaBrSFsrjYAHnoCDT19Gf2hNd" +
       "BvilFIdu6LOGlAtaN4g7a1rfN4eLMzwEzHITHo7ctuZ3G1/mnVyEno/5qHep" +
       "w68hQjgsrNwk/0v4C8HzX3yQdMwwQ3NlvTU+zEwPEJqWBORzA2Z0mQpEtlae" +
       "3HTvR4+aCrgHUFdhunPwO1/W7ho0e86cZVRnDfROGXOmYaqDyWJENyuoFS7R" +
       "+OHBrT9/eOsOE1Vl5pjZAFPCR3/7n5dr73n3BY9AnydZM8UFaLamQaPvZfaN" +
       "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" +
       "u5CvX4V+xV/x7dn/AQJkZru9MAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1470933729000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAALV7eazs1nnf3Kf9WcuzFMuKYlm29ZRYnvRxOJw1suNwOFxm" +
       "huQsXGaGTi1zuAzJ4b4MOXTlDfCCpnWNRk7dNhHawmkTQ4mMwoG7II2CorWD" +
       "BDYSpEFbNHaaFqhbx4D9R+Oibpsezsxd373v+knRBc65HPKcw9/vO9/3ne+Q" +
       "H1/6TumuKCyVfc/eLG0vvqFl8Q3Lrt+IN74W3ejT9ZEcRpqK2XIU8eDcc8o7" +
       "vvjQn//gM8a1K6W7pdIjsut6sRybnhtNtMiz15pKlx46PovbmhPFpWu0Ja9l" +
       "KIlNG6LNKH6WLr3hRNe4dJ0+hAABCBCAAG0hQOhxK9DpAc1NHKzoIbtxFJQ+" +
       "VDqgS3f7SgEvLr399CC+HMrOfpjRlgEY4d7itwhIbTtnYeltR9x3nG8i/Nky" +
       "9MLfef+1f3pH6SGp9JDpcgUcBYCIwU2k0v2O5iy0MEJVVVOl0htdTVM5LTRl" +
       "28y3uKXSw5G5dOU4CbUjIRUnE18Lt/c8ltz9SsEtTJTYC4/o6aZmq4e/7tJt" +
       "eQm4PnrMdceQKM4DgldNACzUZUU77HLnynTVuPTk2R5HHK8PQAPQ9R5Hiw3v" +
       "6FZ3ujI4UXp4N3e27C4hLg5Ndwma3uUl4C5x6fELBy1k7cvKSl5qz8Wlx862" +
       "G+0ugVb3bQVRdIlLbzrbbDsSmKXHz8zSifn5DvvuT3/QpdwrW8yqptgF/ntB" +
       "p7ee6TTRdC3UXEXbdbz/XfQvyI/+5qeulEqg8ZvONN61+fJf+97P/ORbX/nq" +
       "rs2PndNmuLA0JX5O+fziwd9/C/ZM+44Cxr2+F5nF5J9ivlX/0f7Ks5kPLO/R" +
       "oxGLizcOL74y+bfzj3xB+/aV0tVe6W7FsxMH6NEbFc/xTVsLSc3VQjnW1F7p" +
       "Ps1Vse31XukecEybrrY7O9T1SIt7pTvt7am7ve1vICIdDFGI6B5wbLq6d3js" +
       "y7GxPc780v7vLlCg/fH2f1x6L2R4jgb5JjQKvYJ6BGluvABiNaBCURbeBopC" +
       "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" +
       "Kk471nVOQhrtCEJryajSwI0Bms1mUqfs");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("92mZ5AN3Nml2oyqOzWprudpI+JYypfpJG4SkvN9WJLguKH19TbDQXG0jIYin" +
       "tGEOM5zv95Yyj8v9gd4G7lpgA68K9swrgu7L+BKbDJaEjukWGrXnSDcat4a1" +
       "Tb01NaOcU01IoUjJUfWZ4pfbkh3JeVVAqpJjd0xxjQbRjOVanG9hm4Ehc7XO" +
       "sKVMKpK8WCkRU0YctQKWWzsM5YmGqUkdW89qYjkToaypuhA67q+kMGkzKIoW" +
       "j8i+f3uP7t64fRR5lI1r2c3iwrdu4+lcdtEj16Ont0d/p9I5Tzy93bZ87LBb" +
       "WHrioozbbTbT5z/2wovq8JfhK/vHus3iebzn/xVbW2v2iaGugpHedXFeCrNN" +
       "OD5ODvnKx/7H4/xPGx+4jfTIJ8/gPDvkrzIv/Q7548rfvlK64yhV5KZU6NOd" +
       "nj2dIHI11OIkdPlTaSJPHEl2m1v0DlA+spfsR84+Fz+eyJtmaJvz8c6dImyv" +
       "XZxIdPDgmQYnEokOrhXVfXHpgUiLuaP3luc++F17pnqkVQdXbyfjqDhxcPdp" +
       "5k+B8vE984+/TsyfuAXzJ4vqsbh0P2DePfFO++DhY5I/+lpJvguUF/YkX3id" +
       "SD5zC5Llorq+I3nyRdxJkk+/VpJvB+ULe5JfeJ1I1m9BsvB6B5XixbsWY0e5" +
       "ACcpwq+VYh+Ul/cUX/7LoXjHsWtHjqovbQmhtyCLFdW749IbANkTb3tPsn3P" +
       "a2VbpBl9ec/2y687W+YWbIsXRwdUXLq3cE/7134nqfZeK9XroPzWnupvvU66" +
       "O78FwWJBP+DBIlh8YnGYenSS4aU5eJcxfBqUr+wZfuV1YqjdgmHxsvDgAzvr" +
       "3DFEzlC8NHfvh1lKvr6n+PXXiWJwC4pbTPaOolh8U6Odpei8VooIKN/YU/zG" +
       "X6pJgkDr6YsDrW1i/i5F/sV//NTXPvziU/95m5N9rxmJcoiGy3O+sTrR57sv" +
       "ffPbf/DAE7++/f7jzoUc7SKhsx+n3fzt2alPyrbw7z8SSJFLsE0/ulAg58Yv" +
       "i02s+b5fOvZB28l7/hYT+4miykBf35bPLpub20q5Pv/DIX+XuHk6a2CXn5zt" +
       "clAfO6ETu3D+4cvueyIWf+rUxG6/azyMdpPdl43PKS+/2Gc/+L3GL+8+dVFs" +
       "Oc+LUe4Fc7D76mY/Bye/VTg72uFYd1PP/ODBL9739GF0/+AO8LF+nsD25Pnf" +
       "leCOH2+/BMn/2Zu/9O5/8uI3tlnO/x885QvacDoAAA==");
}
