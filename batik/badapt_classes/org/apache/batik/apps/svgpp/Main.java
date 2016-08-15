package org.apache.batik.apps.svgpp;
public class Main {
    public static void main(java.lang.String[] args) { new org.apache.batik.apps.svgpp.Main(
                                                         args).
                                                         run(
                                                           ); }
    public static final java.lang.String BUNDLE_CLASSNAME = "org.apache.batik.apps.svgpp.resources.Messages";
    protected static org.apache.batik.i18n.LocalizableSupport localizableSupport =
      new org.apache.batik.i18n.LocalizableSupport(
      BUNDLE_CLASSNAME,
      org.apache.batik.apps.svgpp.Main.class.
        getClassLoader(
          ));
    protected java.lang.String[] arguments;
    protected int index;
    protected java.util.Map handlers = new java.util.HashMap(
      );
    { handlers.put("-doctype", new org.apache.batik.apps.svgpp.Main.DoctypeHandler(
                     ));
      handlers.put("-doc-width", new org.apache.batik.apps.svgpp.Main.DocWidthHandler(
                     ));
      handlers.put("-newline", new org.apache.batik.apps.svgpp.Main.NewlineHandler(
                     ));
      handlers.put("-public-id", new org.apache.batik.apps.svgpp.Main.PublicIdHandler(
                     ));
      handlers.put("-no-format", new org.apache.batik.apps.svgpp.Main.NoFormatHandler(
                     ));
      handlers.put("-system-id", new org.apache.batik.apps.svgpp.Main.SystemIdHandler(
                     ));
      handlers.put("-tab-width", new org.apache.batik.apps.svgpp.Main.TabWidthHandler(
                     ));
      handlers.put("-xml-decl", new org.apache.batik.apps.svgpp.Main.XMLDeclHandler(
                     )); }
    protected org.apache.batik.transcoder.Transcoder
      transcoder =
      new org.apache.batik.transcoder.svg2svg.SVGTranscoder(
      );
    public Main(java.lang.String[] args) {
        super(
          );
        arguments =
          args;
    }
    public void run() { if (arguments.length ==
                              0) { printUsage(
                                     );
                                   return;
                        }
                        try { for (; ; ) {
                                  org.apache.batik.apps.svgpp.Main.OptionHandler oh =
                                    (org.apache.batik.apps.svgpp.Main.OptionHandler)
                                      handlers.
                                      get(
                                        arguments[index]);
                                  if (oh ==
                                        null) {
                                      break;
                                  }
                                  oh.
                                    handleOption(
                                      );
                              }
                              org.apache.batik.transcoder.TranscoderInput in;
                              in = new org.apache.batik.transcoder.TranscoderInput(
                                     new java.io.FileReader(
                                       arguments[index++]));
                              org.apache.batik.transcoder.TranscoderOutput out;
                              if (index <
                                    arguments.
                                      length) {
                                  out =
                                    new org.apache.batik.transcoder.TranscoderOutput(
                                      new java.io.FileWriter(
                                        arguments[index]));
                              }
                              else {
                                  out =
                                    new org.apache.batik.transcoder.TranscoderOutput(
                                      new java.io.OutputStreamWriter(
                                        java.lang.System.
                                          out));
                              }
                              transcoder.
                                transcode(
                                  in,
                                  out); }
                        catch (java.lang.Exception e) {
                            e.
                              printStackTrace(
                                );
                            printUsage(
                              );
                        } }
    protected void printUsage() { printHeader(
                                    );
                                  java.lang.System.
                                    out.println(
                                          localizableSupport.
                                            formatMessage(
                                              "syntax",
                                              null));
                                  java.lang.System.
                                    out.println(
                                          );
                                  java.lang.System.
                                    out.println(
                                          localizableSupport.
                                            formatMessage(
                                              "options",
                                              null));
                                  java.util.Iterator it =
                                    handlers.
                                    keySet(
                                      ).
                                    iterator(
                                      );
                                  while (it.
                                           hasNext(
                                             )) {
                                      java.lang.String s =
                                        (java.lang.String)
                                          it.
                                          next(
                                            );
                                      java.lang.System.
                                        out.
                                        println(
                                          ((org.apache.batik.apps.svgpp.Main.OptionHandler)
                                             handlers.
                                             get(
                                               s)).
                                            getDescription(
                                              ));
                                  } }
    protected void printHeader() { java.lang.System.
                                     out.
                                     println(
                                       localizableSupport.
                                         formatMessage(
                                           "header",
                                           null));
    }
    protected static interface OptionHandler {
        void handleOption();
        java.lang.String getDescription();
        java.lang.String jlc$CompilerVersion$jl7 =
          "2.7.0";
        long jlc$SourceLastModified$jl7 =
          1471028784000L;
        java.lang.String jlc$ClassType$jl7 =
          ("H4sIAAAAAAAAALVaaXAcxRXu3dV9rSTbsvEhXzKJjNktJxwBAUGWZSyzkoUl" +
           "TJAD69Fsr3bQ7Mx4pldeGUxhCIVJFQ4QE0gKXPlhh5AC25XCgRRHTKgKNkcS" +
           "jCvB3AmpirkKnARSFXPkve7ZndnZQ8ayVbVvZ7tfd7/39bu6Rw9/RMotk7RS" +
           "jYXYuEGtULfG+iXTorEuVbKsQWiLyvcGpH9fe7TvAj+pGCINCcnqlSWLrlCo" +
           "GrOGyBxFs5ikydTqozSGI/pNalFzTGKKrg2RaYrVkzRURVZYrx6jyLBWMiOk" +
           "SWLMVIZTjPbYEzAyJwKShLkk4U5vd0eE1Mm6Me6wz3Cxd7l6kDPprGUx0hi5" +
           "ThqTwimmqOGIYrGOtEnOMnR1fETVWYimWeg69VwbglWRc/MgWLA3+NnxOxON" +
           "HIIpkqbpjKtnraGWro7RWIQEndZulSatDeRGEoiQWhczI22RzKJhWDQMi2a0" +
           "dbhA+nqqpZJdOleHZWaqMGQUiJH5uZMYkikl7Wn6ucwwQxWzdeeDQdt5WW2F" +
           "lnkq3nNWePu91zb+OkCCQySoaAMojgxCMFhkCAClyWFqWp2xGI0NkSYNNnuA" +
           "moqkKpvsnW62lBFNYinY/gws2JgyqMnXdLCCfQTdzJTMdDOrXpwblP2rPK5K" +
           "I6Bri6Or0HAFtoOCNQoIZsYlsDt7SNmoosUYmesdkdWx7XJggKGVScoSenap" +
           "Mk2CBtIsTESVtJHwAJieNgKs5ToYoMnIzKKTItaGJI9KIzSKFunh6xddwFXN" +
           "gcAhjEzzsvGZYJdmenbJtT8f9V207XptpeYnPpA5RmUV5a+FQa2eQWtonJoU" +
           "/EAMrFsc+YnU8tRWPyHAPM3DLHgeu+HYpUta9x8QPLMK8Kwevo7KLCrvHG54" +
           "eXZX+wUBFKPK0C0FNz9Hc+5l/XZPR9qACNOSnRE7Q5nO/Wv+cPVNv6If+ElN" +
           "D6mQdTWVBDtqkvWkoajUvIxq1JQYjfWQaqrFunh/D6mE54iiUdG6Oh63KOsh" +
           "ZSpvqtD5b4AoDlMgRDXwrGhxPfNsSCzBn9MGIaQBPqQcPr8g4u9+JIwMhBN6" +
           "koYlWdIUTQ/3mzrqb4Uh4gwDtonwMFj9aNjSUyaYYFg3R8IS2EGC2h2SYVhh" +
           "a2zEMMK9kqKF0LiM0zNtGrWZstHnA6Bne91cBQ9Zqasxakbl7all3cd2R18Q" +
           "JoRmb+PASAhWComVQnylEK4U4iuFcKW21Qbu2EpJi8HOEJ+PLzcV1xd7Cjsy" +
           "Cr4NwbWufeCaVeu3LgiAMRkbyxDPNHe2WZkfMNAjJ3friweMB17943vf9hO/" +
           "EwGCrtA9QFmHy+pwzmZuX02OHIMmpcD35n39P77no9vWcSGAY2GhBduQdoG1" +
           "QQiFUHTrgQ1H3n5r52F/VvAyRqoNU2ewRxRiS5U0DGFLkhkjFRaPj9CfDURC" +
           "yalfwZ8PPl/iB/XFBmFUzV22Zc/Lmjag7IFmTrEYwOPXzpu374it3rVUeGpz" +
           "rl91Q9p45C9fvBi6752DBTa5wo7hzoK1uF5O9u/lsTGTSaPymw13v/vbtpFl" +
           "flIWIc2gekpSMY93miOQIeRRO4jWDUNJ4GTmea7MjCWFqcs0BomhWIa2Z6nS" +
           "x6iJ7YxMdc2QqRswQi4unrW9oj938/szBy9JrOfm5M7DuFo5pBAc2Y/ZM5sl" +
           "53qw9075UO/DBy87U77bzxMHBuECCSd3UId7F2BRk0KG1FAdbKmHRRd4fdaL" +
           "VlRePE/aF31qcxvfhWrIngxcEhNTq3fxnODfkXEjXKoKQIjrZlJSsSsDeQ1L" +
           "mPpGp4UHkyZhyWAgVWiVs+Dzczs88m/sbTGQThfBh/O3cjofSRu3Lj+YnJEa" +
           "htoP287krO1gcWc63goxXQXnwl1pu1KDrVfiijSsUowjnwcXLd334bZGYckq" +
           "tGS2acnEEzjtZywjN71w7X9b+TQ+GWsKJ6I4bCJRTXFm7jRNaRzlSG85NOen" +
           "z0kPQMqDNGMpmyjPHMR2WRSqi6t+CafLPH3dSC5gpC7BY6eIo7BUe4n601SS" +
           "EOHG7Awe3tz89uj9Rx8RPu9N9x5munX7D78KbdsuUBM10cK8ssQ9RtRFXNZG" +
           "vkUYheaXWoWPWPHPPZuf+OXm2/y2nmczUjamKzEY3FZENVeVG5XvPPxJ/dpP" +
           "nj7GBc0tk90xv1cyhGxNSC5E2aZ7s85KyUoA3zn7+77fqO4/DjMOwYwyZFBr" +
           "tQmpL52TIWzu8srXnnm2Zf3LAeJfQWpUXYqtkLAghbICfIJaCciaaeO7lwq7" +
           "34ie0Mg3leRtc14DmtLcwkbanTQYN6tNj09/9KIHd7zFs43IAkuzfhfEaebA" +
           "Z5ftd7u+jt/h48VunytundeU6Isi+R4jDSOULaeWbCpGNn7OgEMVVxAL5pAo" +
           "mHlHH5KrBSRXnCR62HBVDiQ8hxZOqi1O3S6K1BA/JxnGZCDycS5fAVXFGnxQ" +
           "sgR2G4T0SBK8QSssiI8LImRAwqt6DgBE9wq6AdKtxcdcZrsmfl3OSOWwrqtU" +
           "0hzMExNhXljQG4rBjzSFZAzJOJLrkWzO2R5HwVNgjDeX6PvBCQIq1mOQ+BRN" +
           "Uh1gtyC5BcmtUMiBRfO6Kq/+GUhBiec6dv2tb3aNPtrfJGJvierDO/AOZcdL" +
           "z38a3CIG5gZ7fmS3h3rHHXk18K1a1vYjXrWUYVmFMtdCJreQE2urosd/PpeI" +
           "lg0T+s00x2/48lm3yRh90DF6zoDNd2Htng9YVE5PG5zaXnfFO0Ld+RPgFJV7" +
           "ktGBfUduO49H/+CYAhW9uD0SFzYtORc2mZNFR85FRkEko/LRPXccmP/+2in8" +
           "hCpAQ8lXp4XFrrH9w8f9w8+9HI68OTrZcvBCIiq/uEQ5v+qNww8J1RYVUS13" +
           "zA33f/nSe5vfOhggFVBjYaEomXCOhYNyqNgVkHuCtkF4Wg6joIJrEKMhvmZ3" +
           "AayhOduaLRcZObvY3LymyK/BIettpOYyPaXFcNrveErVlGG4e7ldBU/erm6E" +
           "wu0EwMvqbmc+0sxxb3CsEY857k442kzpinQODEQHr+7vjq7tXNPTuSzC6667" +
           "DOj0DRaP41bxHb1KUWNdkhkTfrnrq+qFl04/eCH3y3zgTjVYPMhqac/BebLB" +
           "fk+pYH87km1IHkayG8ne0xfs95Xoe+wks+ejSH6D5HEI8gko9Lrg7FgofwYU" +
           "+2Z1MnD+vhScTyB5EsnvkDyD5NmvB2fAgROKAU3C+ntCXA+W6HvhBHF1Ft6K" +
           "5DkH4QNInkfyIoqkMyXOS4NVkwbzlVJg/omvgeTPSA4hOXzSYLp0KiHQkRJ9" +
           "r08ayFeRvIbkDUaqBZCdqnpqsHy3FJZvZ7F8B8nfkfzj9Pn5eyX6PjhJPz+K" +
           "5H0kH4KfM911/ih9MDlJPD8thefHSD5B8i8k/0Hy2Wm2zeOlzyutDgI9eD1p" +
           "pgwor7rTMuUnOD7FF5M24f8h+RyIDzJZ2UZJYafEen2VJdD2BTLW6ytDUoGk" +
           "6tRarxtMT9ooU3VthAtZX3gQ/vySMzR/rQMLxzcLra8OCd54+KY4Sk8a2DNO" +
           "DNgWJDOQzDwNZuzPau1rwLYnuWhzJ4Jz/mTN1deKZB6SBacQ02+eGKaLkHwD" +
           "Sbvdn2akPuelSsZ55030LgZq1hl5r3PFK0h5945g1fQdV/6V3xRnXxPWRUhV" +
           "PKWqrureXelXGCaNKxypOnHXxi9PfCFGZpUQBg7Z/BsF950thiyFmrbgEPAd" +
           "/HLzngOh2ssLc/JvN9/5jNQ4fFB2iAc3y4VQ0QELPnZA9ewrUjZPm2iPXe9h" +
           "FhY9aPamxHv2qLxnx6q+64+dt0u8sYLafdMmnAXOZ5Xiqp1PGsg7Ebtny8xV" +
           "sbL9eMPe6kWZ+9QmIbDjbrNc8f8q8A0Dbxlnei6srbbsvfWRnRc9/dLWikNw" +
           "xF5HfBIcktZFvHdlHWkjZZI56yLO+df1Xxr8PNbR/rPxS5bEP36dX1QScV6e" +
           "XZw/Kh9+8JpX7p6xs9VPantIuaLFaHqI1CjW8nFtDZXHzCFSr1jdaRARZlEk" +
           "tYdUpTRlQ4r2xIodd+tzjruMLMi/0Z7weFsfIbVOi9iZkideHOC0ZLdyar7u" +
           "UXn57cEn72wOrAC/y1HHPX2llRrOvvhx/0cAb3BfwOM+g0VHI72GkTksBg7Y" +
           "nna54MF2ONsutu+Oc4Omr4+7RS9/RNL/f/gr/SrsIwAA");
        java.lang.String jlc$CompilerVersion$jl5 =
          "2.7.0";
        long jlc$SourceLastModified$jl5 =
          1471028784000L;
        java.lang.String jlc$ClassType$jl5 =
          ("H4sIAAAAAAAAALV7C7ArZ3nYnnMfvr42vtc2tqnBxo/rTEHkrLTS6lGThNVK" +
           "q11Jq33puW25rPatfWof0moTM4Q2gQkN0NQkpAOedgb3kSEh0wmTzmTI0KZJ" +
           "MAlt06EJdBpgOmlDQmjDtCSd0ED/XZ1zdM65D4OvOTP6tPof3//93/Pf7/vP" +
           "x78OXQgDqOB79ka3vehATaKDhY0eRBtfDQ+6fZSVglBVcFsKwyFouy4/9ctX" +
           "/uJbHzSu7kMXRehByXW9SIpMzw15NfTslar0oSu71ratOmEEXe0vpJUEx5Fp" +
           "w30zjJ7tQ/ecmBpB1/pHJMCABBiQAOckwNhuFJj0GtWNHTybIblRuITeCe31" +
           "oYu+nJEXQU+eRuJLgeQcomHzHQAMl7LfY7CpfHISQE8c73275xs2/KEC/PzP" +
           "vf3qvzoHXRGhK6YrZOTIgIgILCJC9zqqM1eDEFMUVRGh+11VVQQ1MCXbTHO6" +
           "ReiB0NRdKYoD9ZhJWWPsq0G+5o5z98rZ3oJYjrzgeHuaqdrK0a8Lmi3pYK8P" +
           "7/a63SGRtYMNXjYBYYEmyerRlPOW6SoR9MazM473eK0HBoCpdzlqZHjHS513" +
           "JdAAPbCVnS25OixEgenqYOgFLwarRNCjt0Sa8dqXZEvS1esR9Lqz49htFxh1" +
           "d86IbEoEPXR2WI4JSOnRM1I6IZ+vD976/h91SXc/p1lRZTuj/xKY9PiZSbyq" +
           "qYHqyup24r1v7v+s9PCn3rsPQWDwQ2cGb8f86o99421vefzTn9mOef1NxjDz" +
           "hSpH1+WPze/7vTfgb2qcy8i45HuhmQn/1M5z9WcPe55NfGB5Dx9jzDoPjjo/" +
           "zf/W7F2/oH5tH7pMQRdlz44doEf3y57jm7YadFRXDaRIVSjobtVV8Lyfgu4C" +
           "z33TVbetjKaFakRB5+286aKX/wYs0gCKjEV3gWfT1byjZ1+KjPw58SEIug98" +
           "oAvg88+g7d9HMhBBAmx4jgpLsuSargezgZftP4RVN5oD3hrwHGi9BYdeHAAV" +
           "hL1AhyWgB4Z62CH5fgiHK933YVoy3YNMufzvD9ok283V9d4eYPQbzpq5DSyE" +
           "9GxFDa7Lz8fN9jd+6frv7B+r/SEfIugArHSwXekgX+kgW+kgX+kgW+ka42cS" +
           "IyVXAZKB9vby5V6brb+VKZCIBWwbeL173yT83e473vvUOaBM/vp8xs8kN7bX" +
           "5T/OgXlvurUnJjI3QOWuTwaa+bq/Yuz5u//b/81pPulMM4T7N9H+M/NF+OMf" +
           "eRT/4a/l8+8GficCm8lM+vGzNnjKbDJjPMtL4E53eJFfcL65/9TF39yH7hKh" +
           "q/Khrx5LdqwKKvCXl83wyIEDf36q/7Sv2RrWs4c2HUFvOEvXiWWfPXKM2eYv" +
           "nJQheM5GZ8+Xc324Lx9z/3fA3x74fDv7ZJLIGrYa/gB+aGZPHNuZ7yd7exF0" +
           "ATmoHRSz+U9mMj7L4IyAHxL8j37h3/9JeR/a3znrKyfCH2DCsyccRIbsSu4K" +
           "7t+pzDBQM2b94YfZf/Shr7/nb+f6AkY8fbMFr2UwoxhEOxA1fuIzyy9++Usf" +
           "+/z+sY6di0CEjOe2KYOHMA9eYCea6Up2zpCnIuiRhS1fO9r1GAQzQNi1hV3L" +
           "WfUQCN85aZlUDrYRIDcsQNG1W6jriah9Xf7g5//8NeM///Vv3KCppxlDS/6z" +
           "WwnlVCUA/SNnrYiUQgOMq3x68Heu2p/+FsAoAowy8AghEwBTTk6x8XD0hbv+" +
           "y7/5jYff8XvnoH0Cumx7kkJIWYAFbjIyQEw2gBdI/B9529bNrS8BcDW3TSjf" +
           "/+u35ORmfd+OEX0PBML3/dEHf/cDT38Z0NGFLqwyHQYUnODWIM7OBj/58Q89" +
           "ds/zX3lfLhMI2hu/65mvvSvDWs8XeCaHfzMDha3Esse3ZOAHM3BwJKZHMzEJ" +
           "uQfsS2FEe4oJzgZKLqnbug42MB2gbavDwAc/98CXrY989Re3Qe2snzgzWH3v" +
           "8z/1nYP3P79/4ijx9A3R/OSc7XEiJ/o1x6J88nar5DOIP/7Ec7/2L557z5aq" +
           "B04HxjY49/3i7//17x58+Csv3cRLn7e9I6XMIHK4bPaFvrxgo6tTshJS2NFf" +
           "fyxJU0xO+GlcVsaNQBjOw1XbmKa97mJgRd1k3cRGnYkobFLLG9nDLtaqNogw" +
           "KM+5Gp1UfBBUOqPEwKlxl+AqXLuo96asbRgohiPoFNd5nhz29N7AkoUFvmqW" +
           "MWB4gdVzMV4gpqy1Umuiq7giV5c24/l4JdYiTanB5cY8rvLrBszTXmTVeGEx" +
           "m87idica9bVOwZwOvaAdj+e9kJuY/c1K7vhkQ1NrwxW2KPgdnBrgsru0hUk/" +
           "sHGvEzCdTTMhQtS0Nspw6aVCh4L9gWQT6bDT6wU6wkuzYGyl/Igfi7MgqS42" +
           "/eaENhkLoKDHlDhcsPNZO8U23XVPMPqWVRmhK6Wotku0U6XV6jot44lSs6tW" +
           "i/UDwJCiYaJDYzlcm46zZDrULOgwUdtlaJcvae3heDIznYmqVxvj9Vy3J7wM" +
           "0/qkj5ULAzdhEmZAUpRvLef+ohe5gdSZBF6Nn1Bc21XE2BakqKXynbZnchND" +
           "TikE4YG4jEmLo01EKipzAyu4y6UvdhXGVklxIi3pDjcyuyQai/TMMi27NnGr" +
           "sbxec8kkVVS1xSkROpkghO1ay7I7mKhs3Cil8wJj4Ti3ETwJo72FnuA0YVg4" +
           "htubCbGc+EjSoYoDS5gNBm6MOd7S6vmr0J1UEbtJDGamO4P1dYh09c2SdqdK" +
           "H8c1bqik3SGttJhg6q/nNosEbA/tUdVmYFaZoEhiROQx+IDzKDGc2WErqgkD" +
           "x/PC0cxRQ8VSJklt2tX1XmcsyJ6gupJPWwjejKhw2BbGUZdcY11THei9EB16" +
           "M492qbTXG1KR1OlSjR6VCj0ido1qoihrYjrQZcxYtNM0XHXEWVdxVHfejYZ1" +
           "rTFGirWpH/nqzGV9DOWd0RiVCgQnISo3iTy3643gNkYHRCgXZu6oHvETdkNi" +
           "LF1u9UldjQvkzB9FUiOpc2yf7tV7a3Xl1Xp9PFiRHbSiTsVpYT1qEj22V8SL" +
           "xCBtkHIBteGpyPKNJYYPGMHl2zUOdRl4sirI7HiwqlJaoW0PWlWHU4aTcbMV" +
           "La3VxPKkxWhFJctSl5sttAknLYNsizAY10YrpjlSOlXGqJZ7TGiIgr9aRi10" +
           "XsG8lk3rfGu6DjpGwmqDUMDTptugO5TENdklJ7NBXa/EjUKXWtNGc1C1vJk9" +
           "UajRkIPLThos55WRUdHXLcCNNU0sGtJgIYw20mxG6GW+TglIu4MjBiLMxoYh" +
           "IWmbpnsNa9kjin2TLqaDqBNMxDAiXazadNVGSW5yDXEphYlkze2aZNtlWUH4" +
           "Up3rerwzL7CYgBkTELjHnLux273KqGLGhNybICVuHiNtv2vWSabdLbD9VB6X" +
           "gDXii3CDB5XBej6JNRWXxmpc7usmRvPWfJO02AGpIhPR0ugBtuiWtcBcq3Sz" +
           "VGtUyiutYTBwe93BgwhrcIRDbgr+OnXEeFpEGJKiHV9ulVG33GBrNddrrCay" +
           "0MFmSMdoKjGneJ0Sx5nEiBwGOlciyy4aoAgBj1fYhl96gxGirvmENwV0VGx1" +
           "iL5lWAuCl9hFA9daIx7fSLa2Fussa8NmE54STYcYpWMEEWW47ywkvUYRzjBo" +
           "z9YMO039uFyrmFE5GI/Ujp8GdqPENfwKije0VdOs1lCk1RxK6NqrGanXK8UE" +
           "yjRi2A6HnaEgsRtnXSqv4NU88glbs6kJJSO6avkCPWuUHZPhKJXnmcpi0hoN" +
           "upXO0FGlGr3AgfHLYbHpOcaEkhCx6gpJ1ezWZgmtyAi35MM1Z1ZiN5g0vEWj" +
           "XIfDtLlpdANGc1C61ooJD/WbmIzMYJFGQxstL9eNYg0dMXCruanXRrXaPE1o" +
           "shm3cVxQyiNKqRFIk7eKvU6JwJR5zyF5XqloitQf27zKtmGJKJeWcrLSjAk4" +
           "J+uJ3DYGw2VZS1ympVnT9mLa83octQhEuyuEQthSuVLfYf2OXxmR1kY0NhNM" +
           "H0/McVhopXIa1usOHM6HHW5oaE0DZsrywtMEHujPAlh7ty0Zkcci9ZoVMCVd" +
           "nsjVsu4lU27qru2SH5d6rWCsmeZCCEfeeuGu5WlfKZcrc7Ezk61l1BEQSXbb" +
           "7XQRiZv1YlArrWvTxrww5AqdSdjrVqnKHO/ywynh1Bb8QOJTW+jU0QGjumnR" +
           "Yjl62Rp0aN/ZLFiS5pEJLyzNalTAJa3PkmVFwFHdx2vNWVWlvFpzpFbcarEk" +
           "CG2G7NSwtVqO0nojXjT4pM4DNz9oJKgTu9Naq1bvzZUwHjXpUlHu1cOQa/AR" +
           "D7yk2FlZo5mhStOJN2EnLMmyYqwVmKmDwBvEdeR0tJCcXtqelQmxPRir4w46" +
           "XbFs0oUVn3UXtU5TLkZWo5isSvLG6CQDQGMbkcRaWEd7m5GHlVO3VqjVtCVT" +
           "gVsLmlnP1huRaAYR5/h9FBlSkzSuh8HUdR1E1Mp9TO1q3MQfTWfLyOpjujGn" +
           "cI3qSrhsSpLK1Oz1slaumGqR1su2ykdyqdJyor68tuaSO+Rmg2o0WBQbMIgI" +
           "pFJLibBSpjArTjVDa0vqHBNRLVJqcWERwUalPo7dTRS7ijqqUqFZ4CuLlsCM" +
           "+pI6meN+Z+DWGL1Nj8cJ1kd9zHNImyTRXtAU+KmL81WEbI5bJlc3EpFZmiWm" +
           "LFR7pSYGdxO3I+KtjSygGjaeEh034UKdRzqVYVFo9uqcEIYmVe9TDo+tl1G1" +
           "pTfbjfWyiim9KJEVWQxCR7PLjMBM1sEyGhWNlG4nA2NqL7hOJWguUoEQsbTL" +
           "dPuBNUkZhEfJ9XigL1rqtMqumjhHLUsOwxWa/GBklPRog6NN2YlGtNnkNaba" +
           "W8KFzshomqpcVVZINC9LAzYKtG6nuzLVoMXAGCPKSj8t16UyTnVQXaxpjlA2" +
           "ygFJTq1SvVeSSqvZYhpMRrOxQ9CRgncDlWsjceCFCsz6KmXrxWEhLBYTBK7U" +
           "bae84Y1GsUVUU681UBAycvXGbNxG2Q6aSlNXI5hiXynwrE50xzUr6jS1kRIz" +
           "lQYJF/AZCA+NuFUUiHQWMbyMOOKA4OsowVtty4P7PDuVZYeFC4jp1g3cx7i6" +
           "PfUrUyIIyMYahPx1vdAgqWqdGQaiDNhDmUs4bnPoqrAcrNf1bomfjUdCqZxi" +
           "5bIGu4KKrjTG0HVi3FzMpLbnTHHGmA02y4E+tsgYjyyiMtGrC4/qBu0ebawc" +
           "sYxJG4NRYqnPyyIzX83K/Y2z6cFNSo0in5ltWGlKyINgpbaDsd3pVNSarTRH" +
           "sBo41fY6LrbX9Go5d+RCMUySeRkP27M6WrMqFcRKfdPlmFabI4NCbbVY1qLp" +
           "gB3GQopXq9Vai1kUWyDGVErzhJyXeqPJQAFxZ6gFbrAsLAm7WIFVnCxvyqk+" +
           "XIxnLG0sJRluqvN+U7MK/owEzs4pUaQlbTp1Vy0mWthAp55aWFthQV0IZLWF" +
           "km2qrlteox/oNUL3tPVsVEDEEu22CitDkIebJtoO3ZXV2rTQgbNqIhqm80wP" +
           "G5XxghvhU6wwqZIro0kSJSKq9tCWRVa4AeVa2oYCZ0t6M2WEymBsreepPe7q" +
           "sOesdHXICljFYKapMOv7xZ5JchbfbQRF8EJBqPyKmlutkbRsiriydP1lSG7K" +
           "RFcE7xlEvVl3NUtLFw3WRdUNMImF0WXTQg8li2DhnkY3SiXYNBp0y+6yrXpk" +
           "qBoptNBm3axbcJHcIBMHSVXGTjdx1NKphtoq+b6+9oJaMKTjEQg9NYJAaaSi" +
           "1Y0Cv6FaaVdERmJ3Jmlt1UXGXaWFNIf9SXUTtUZex6pGvBQkET1seN6oPI4M" +
           "LBKnZZ2DVxuBTnk44Oh+ksr9QKozuIJWCr1ZRbDqEtIaMK2BPum2GC5trQdi" +
           "nLJSXArW/ZkbT4y0W+mmsDMclBS1JzarQlOSuSJSUDs9qW+R65YwXykuIlls" +
           "rNpCKKJosVzs6+KyZNhoUGaJXtFAGxVUL2mcMoar43LCu9OEnfAjY8z2Jssg" +
           "DtSpak87uDToJRufcclpYjZYDSc6oj/imnpNhJsh0UCLkWFuCCeY620WU2Cy" +
           "n7o6YyBh2Jfh7mrQgNHFgKtoRBMxMbm8qYy5Itfus66INdR1MFqIrIOY7FRt" +
           "GIQxa0is5CTkCln2EzepLgvVSkGJiiBMzPqSptCOi00ZEZ2aS7/EdkK91p5H" +
           "7qaejMN5v6HSrFq1JmKhwTnUvLWYBwO5rtWXdazYmie2q5rVMJiDV2Ftwru8" +
           "3ICV/sS0BuuEQEmtSclWJBIrUrHJibUQRQqtbvpMQdFK0ySos4M5EBabCOi8" +
           "zZaryrTECfK4Co78a7hnNAr1rj+t+dUkbIxZyY0o4A0IiVxSJXwxqbtE1BKn" +
           "ZIoTQlBaKBKP8aLdtqKZMvKHvM1VAiShPEUpROkiiOk+bcJFsbZWiVCj5mPG" +
           "bJiiZSoqyeBFsa9spKAWj6YuWpPbbg1ZMwGGw5sSSbJTxLb5gFmtjAQuyti8" +
           "3NTWDF3Qi2OSqiEda2iFQG4z15XQCk0gzCCMo7jAyBXGCSoF8EYO3s0HfViD" +
           "9QAWgpBaY1iWYqC+tyzP/Xky7rg2s7BrWUfxe8huJDdf8HwE3e0HXqTKkapE" +
           "0CVpHkaBJEc5CaDvuHC0peREZhrKMjiP3aoEk2dvPvbu519QmBdLWfYmm9iK" +
           "oIuHlbEdnnsAmjffOk1F5+WnXSr5t9/9p48Of9h4R55LvSHF3YcuZzPZrMp3" +
           "XM174xkiz6L8l/THX+r8gPwz+9C548TyDYWx05OePZ1OvhyoURy4w+OkcgA9" +
           "dUNuy5NVBXiA3bpvfkL65PVPPXdtHzp/MtueYXjsTO76Hs0LHMnOFjiqxF2O" +
           "jMBb71pOJrIBWzPRQ68Hn39yWKrJv7PeB/0MvjbZKc8NWrF/rIbCodwD6Ad2" +
           "OVTcs22gMBnXr41cJ085SnNbzeoZ/+/KM6VP/tn7r24TcjZoORLDW14ewa79" +
           "bzShd/3O2//y8RzNnpzVNndZ4d2wbcHswR1mLAikTUZH8uP/6bGf/23po+eg" +
           "PQo6H5qpmlewoEPdzYjacneeQ+1Mn5mBt0fQvUZew9nWc/KRP3LC0vAIOr/y" +
           "TGVngtdfLsF4cqG8QTwW2ZWs8THwefFQZC/ekchuvbnVbfpysIyg+3Q1aqmh" +
           "HJj+UUmiuNtm8Eq3mVdUbl5iefhsmecgL+H7/p1sey8ftXeTosV2jXzS37sN" +
           "P96zpT4D78wb/v7NCdnLCdnSkIF3Z+AnM/Be4PXUZSzZ4c30566559mq5O54" +
           "+86X4+3NCf2ZDLwvA/8gAx/IwD88S/yroDw/d5u+n/8umbVb72DHsZ/NwIcz" +
           "8I9BIALqlweT20cHIQbx6kTd/6fNFz732W9e+fFtveB09SO/+nE49ey8L37h" +
           "HHJPdO0DeVQ5P5fC3I9fAl44zEZG0BO3vkaS49qWNu55WSV/aKfk+fLHOn6k" +
           "oVd2GpoPyJo/dqpWcnMmXJcp57rwyS++p5q7zCsrMzRBSB8e3mw57UB35edn" +
           "T912uSmbrstf/cRPf+bJPx0/mF9j2HIkI6sMnG/2XT3U1L1cU/dzewugZ25B" +
           "8CFFub+/Lv/YR779uT957ksvnYMugpCWxV4pUEGYjaCDW93+OYng2hA8tcAs" +
           "EJDv2842Xf2YcUCADxy3HkfgCPrBW+HO62JnAnV2f8b21mrQ9GJXOYzOp6J/" +
           "7Psne3NVuPeVq8I7Qaz8Lph3vPfDaAE9kCv9iXJkViA72elH0IN4HxOE68MZ" +
           "274+xngKa/bbuYr5oHNvmNtschvpTUxbwaVA2ZrNi9+5++m3PfLS38rN5kYm" +
           "vULG3DoQ+Fv6Tl6QOAwvd+I5fz0DH83AP83Ar2XgU98Hz/kbt+n7zVcYZv5t" +
           "Bv5dBn4LOE1DCg3cU9SbBZpz5uHtuDth1X/MwEsZ+GwGPpeB//Bdsmr3biOA" +
           "iOhKWaH3ZXn2+7fp+8J3ybPdwgcZ+PyOe/85A3+QgS9mJHmRqW2yX9YdM+or" +
           "GfivOa4M/GEGvvy9M+oEvbdZ7L/fpu+P75hJf5SB/5GBr4IXwi2TMNt+dfj0" +
           "vzLwtWM+/VkG/uf3wfb+z236/uIV2t7/zsA3M/CXwPYib3cNpnjHfPl2Bv4q" +
           "x5WBb2Xgr79P+rN37vaH5sd3EYXK0gFB7IOTRTuR1fzVIEdx4U7VbC+T5t75" +
           "DFwCb1VryYxeFQ3bu5KBe440bO/eDNz3");
        java.lang.String jlc$ClassType$jl5$1 =
          ("KmnY3k4vmvlir73lgL2L+YCH7+CEvPdgBh7KwCO7Td0xgx47zaBHM/CGV1PV" +
           "9nc7ambgs/myt+blIauu3bFKPZmBpzPwzKvIr8JpfmWU7L05iaDXnLr0eWQ8" +
           "T7zcXVFw2HrdDdfNt1ek5V964cqlR14Y/UGeITq+xnx3H7qkxbZ98j7jieeL" +
           "fqBqZs6Fu7dJofwNeq8YQa+/DTERONln3xnhe/B2ShmcUm86BVho9nVybBW8" +
           "XZ8dC3Dm3yfHNSLo8m4cCLvbh5ND3gpOK2BI9vhD2S3LWxz3Hng5+Z1IVD59" +
           "y3ccOt7+H8B1+RMvdAc/+o3qi9trmuDMmaYZFvAScdc2/ZYjzVJZT94S2xGu" +
           "i+SbvnXfL9/9zFHq874twTtTOkHbG2+eGGs7fpSnstJ//civvPWfv/Cl/Krg" +
           "/weokxbmnjEAAA==");
    }
    protected class DoctypeHandler implements org.apache.batik.apps.svgpp.Main.OptionHandler {
        protected final java.util.Map values =
          new java.util.HashMap(
          6);
        { values.put("remove", org.apache.batik.transcoder.svg2svg.SVGTranscoder.
                                 VALUE_DOCTYPE_REMOVE);
          values.put("change", org.apache.batik.transcoder.svg2svg.SVGTranscoder.
                                 VALUE_DOCTYPE_CHANGE);
        }
        public void handleOption() { index++;
                                     if (index >=
                                           arguments.
                                             length) {
                                         throw new java.lang.IllegalArgumentException(
                                           );
                                     }
                                     java.lang.Object val =
                                       values.
                                       get(
                                         arguments[index++]);
                                     if (val ==
                                           null) {
                                         throw new java.lang.IllegalArgumentException(
                                           );
                                     }
                                     transcoder.
                                       addTranscodingHint(
                                         org.apache.batik.transcoder.svg2svg.SVGTranscoder.
                                           KEY_DOCTYPE,
                                         val);
        }
        public java.lang.String getDescription() {
            return localizableSupport.
              formatMessage(
                "doctype.description",
                null);
        }
        public DoctypeHandler() { super();
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471028784000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "HvhRbyHIO/no8/yVNb/4Dw+kBZqeGgAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028784000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "53w1jHybO3Y4+foDa1zIlP8weL6wZ40vXPvi4/qmfdPWg25wsv7LNxh7f9b8" +
           "Ugjdtsgtt7ViDikd8Tc1hE6vHUM5dMTHX+7o5ehEecd7DmS+O+u8BJ4X9mR+" +
           "4f9e5o/eYOyprHkihM7rathUA9k33P1LIf5Qwg+/EgkTQO34JeN+5Dz4cpED" +
           "fPzeq/6/YXsnL3/umQu33PPM5K/y+7iDe/NbaegWLTLNo4ffR97Pur6qGbmk" +
           "t26Pwt3855kQeu0NmAmhM/lvzvjTW5TfDKG7rokC/CH7OQr7bAhdPAkLaOa/" +
           "R+E+FULnDuFA2G9fjoJ8OoRuAiDZ62fca5zybq8MklNHUsWek+WWu/PlLHeA" +
           "cvR2L0sv+b+j7KeCaLB3bv/8M1323S9VPrm9XZRNKU0zKrfQ0M3bi86DdPLQ" +
           "dant0zpLPfrj85+/9ZH9vHd+y/Chwx/h7YFrX9+1LDfML9zS37/nd9/6qWe+" +
           "mR86/zepxRSBJyQAAA==");
    }
    protected class NewlineHandler implements org.apache.batik.apps.svgpp.Main.OptionHandler {
        protected final java.util.Map values =
          new java.util.HashMap(
          6);
        { values.put("cr", org.apache.batik.transcoder.svg2svg.SVGTranscoder.
                             VALUE_NEWLINE_CR);
          values.put("cr-lf", org.apache.batik.transcoder.svg2svg.SVGTranscoder.
                                VALUE_NEWLINE_CR_LF);
          values.put("lf", org.apache.batik.transcoder.svg2svg.SVGTranscoder.
                             VALUE_NEWLINE_LF);
        }
        public void handleOption() { index++;
                                     if (index >=
                                           arguments.
                                             length) {
                                         throw new java.lang.IllegalArgumentException(
                                           );
                                     }
                                     java.lang.Object val =
                                       values.
                                       get(
                                         arguments[index++]);
                                     if (val ==
                                           null) {
                                         throw new java.lang.IllegalArgumentException(
                                           );
                                     }
                                     transcoder.
                                       addTranscodingHint(
                                         org.apache.batik.transcoder.svg2svg.SVGTranscoder.
                                           KEY_NEWLINE,
                                         val);
        }
        public java.lang.String getDescription() {
            return localizableSupport.
              formatMessage(
                "newline.description",
                null);
        }
        public NewlineHandler() { super();
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471028784000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "zgM/5i0EeScffYa/suaX/wGb2zLNnhoAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028784000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "60RDCyskAAA=");
    }
    protected class NoFormatHandler implements org.apache.batik.apps.svgpp.Main.OptionHandler {
        public void handleOption() { index++;
                                     transcoder.
                                       addTranscodingHint(
                                         org.apache.batik.transcoder.svg2svg.SVGTranscoder.
                                           KEY_FORMAT,
                                         java.lang.Boolean.
                                           FALSE);
        }
        public java.lang.String getDescription() {
            return localizableSupport.
              formatMessage(
                "no-format.description",
                null);
        }
        public NoFormatHandler() { super(
                                     ); }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471028784000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028784000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "nR84/g8NeDOepCAAAA==");
    }
    protected class PublicIdHandler implements org.apache.batik.apps.svgpp.Main.OptionHandler {
        public void handleOption() { index++;
                                     if (index >=
                                           arguments.
                                             length) {
                                         throw new java.lang.IllegalArgumentException(
                                           );
                                     }
                                     java.lang.String s =
                                       arguments[index++];
                                     transcoder.
                                       addTranscodingHint(
                                         org.apache.batik.transcoder.svg2svg.SVGTranscoder.
                                           KEY_PUBLIC_ID,
                                         s);
        }
        public java.lang.String getDescription() {
            return localizableSupport.
              formatMessage(
                "public-id.description",
                null);
        }
        public PublicIdHandler() { super(
                                     ); }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471028784000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028784000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "lRcbPaQgAAA=");
    }
    protected class SystemIdHandler implements org.apache.batik.apps.svgpp.Main.OptionHandler {
        public void handleOption() { index++;
                                     if (index >=
                                           arguments.
                                             length) {
                                         throw new java.lang.IllegalArgumentException(
                                           );
                                     }
                                     java.lang.String s =
                                       arguments[index++];
                                     transcoder.
                                       addTranscodingHint(
                                         org.apache.batik.transcoder.svg2svg.SVGTranscoder.
                                           KEY_SYSTEM_ID,
                                         s);
        }
        public java.lang.String getDescription() {
            return localizableSupport.
              formatMessage(
                "system-id.description",
                null);
        }
        public SystemIdHandler() { super(
                                     ); }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471028784000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028784000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "AX4IEN2kIAAA");
    }
    protected class XMLDeclHandler implements org.apache.batik.apps.svgpp.Main.OptionHandler {
        public void handleOption() { index++;
                                     if (index >=
                                           arguments.
                                             length) {
                                         throw new java.lang.IllegalArgumentException(
                                           );
                                     }
                                     java.lang.String s =
                                       arguments[index++];
                                     transcoder.
                                       addTranscodingHint(
                                         org.apache.batik.transcoder.svg2svg.SVGTranscoder.
                                           KEY_XML_DECLARATION,
                                         s);
        }
        public java.lang.String getDescription() {
            return localizableSupport.
              formatMessage(
                "xml-decl.description",
                null);
        }
        public XMLDeclHandler() { super();
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471028784000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028784000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "dIgyvGhUo8lwvWqOwYbine/MthrveX27vXvyje3BFQPY5GUDndexy0luPiHY" +
           "dJ/3AjcCG3tVSQ5O+fLzjrtvc8p35CTk1P7uevc1T3c5Lzv02DvczXaCD9/q" +
           "JiLfBX72Ay+8pHCfK+3sHTxNwcZ/74LocPodIOZtt97udvNbmMPTkK994J8f" +
           "HL3LePp1nPc+ekLJkyJ/p/vyNzpvlX9jBzp9cDZyw/3QcaZrx09ELgCIjwNn" +
           "dOxc5OGDaFzKnP8E8PS9e9G49+ZnrjePcJ5S20S6zaHe6jZjeeNH0F1GHrlt" +
           "FHPKwZG0m4Ct98o1lcN8DF5r1310orzDObD5/qzzKlD/oT2bH/q/t/mDtxl7" +
           "LmuejaCLuhq11VAOTG//PLpzaOH7X4+FCZB2/H5jv3Iee63KATn+wA1Xq9vr" +
           "QPmLL10696aXxn+VXwUcXNmdZ6FzWmxZR8/djjyf9QJVM3NLz29P4bz85/kI" +
           "evNtlImgM/lvrvjHtiwfj6D7bsoC8iH7OUr7yQi6fJIWyMx/j9J9KoIuHNKB" +
           "st8+HCX5dASdBiTZ42e8mxzwbU8rk1NHoGIvyfLIXXmtyB2wHL1YyOAlvwnf" +
           "h4J4exd+Xf7SS3Tvfa9WP7e92JAtMU0zKedY6M7tHcsBnDx+S2n7ss6ST/30" +
           "4pfPv2Uf9y5uFT5M+CO6PXrzmwPc9qL8rD/9gzf93jt+66Xv5ueN/wPOipfW" +
           "oiAAAA==");
    }
    protected class TabWidthHandler implements org.apache.batik.apps.svgpp.Main.OptionHandler {
        public void handleOption() { index++;
                                     if (index >=
                                           arguments.
                                             length) {
                                         throw new java.lang.IllegalArgumentException(
                                           );
                                     }
                                     transcoder.
                                       addTranscodingHint(
                                         org.apache.batik.transcoder.svg2svg.SVGTranscoder.
                                           KEY_TABULATION_WIDTH,
                                         new java.lang.Integer(
                                           arguments[index++]));
        }
        public java.lang.String getDescription() {
            return localizableSupport.
              formatMessage(
                "tab-width.description",
                null);
        }
        public TabWidthHandler() { super(
                                     ); }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471028784000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028784000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "L8Ivfeoh4ud/kOPvwj3DfiS5MSGDmmyHW/qc8697T5z/0z3oThG6Ih8UfFPJ" +
           "jrMgEkGREx5WgaAoPDF/smDZfp2vHaWzN59ONceWPZ1odh8C0M+gs/6lncGf" +
           "Ss6AQDxX2q/uI9n7O3PEx/P2atb87FbrWffnQMSGeeEIMDTTleyczlMR8Bhb" +
           "vnoYo1NQSAIVX13Y1ZzM/aB0zr0jE2Z/W31tc1XWlrdc5P3KLb3h2iGvwPr3" +
           "7IhRHijkPvQPz3/zI2/5LjARCZ1bZeoDljm2IhNnte2vvfSxh1/3wvc+lCcg" +
           "kH2mzz75g2czqv3bSZw1zaxpHYr6UCbqOP+CU1IY0XmeUJVc2tt65iAwHZBa" +
           "VweFG/zMfd+1PvX9z2+LstNueApY/eALv/7T/Q+/sHesFH7LDdXocZxtOZwz" +
           "ffeBhgPo8dutkmO0//GLz/zhbz/z3Jar+04Wdi2wb/n8X/7XN/c/8b2v36TK" +
           "uMP2/heGje5SumjYww9/1FSQSmuumPCFuIzOS6WQ7tBBU287wwmrx8t+mxEJ" +
           "mek0wxI/KbSI6ZRZu2QZi6sxyjiioErxaiIZYxE33UGCm2S/NQialXWxK/V1" +
           "e1SUzKhkjThLI4clyyc5JUaIpct1K9yg2G/0K0NQjcWazFbDlC3EXS7ggqpS" +
           "FtVarV5PN7BcqNRkcsCxzbkv4NKgxjsUO28VdLQ+LpXaywBBFSxt0qQ4dZeF" +
           "hbaoI8JqEdFSqJBjTKgM136Rp+COwnAiiYXIutDlOFJPU9Lss4gYYYtG1XIp" +
           "hqHnZCdExLTtVHzHqG3aQ7FlbAzF64c+mYKqLRiUpCalkwxDiLhFmWOyug5j" +
           "ZaP0rBIpIUkVY406FpRq7f5soPJD1A0Ea6KQVKdWTCfo2mVQBWk79cRwNB8Z" +
           "LRSw9BSt9saFYjprrOWJShgMsjJSrDCYY/N+uF6P/WWHEGaVhdN1OoOlhSSM" +
           "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" +
           "/g87jAlxqCAAAA==");
    }
    protected class DocWidthHandler implements org.apache.batik.apps.svgpp.Main.OptionHandler {
        public void handleOption() { index++;
                                     if (index >=
                                           arguments.
                                             length) {
                                         throw new java.lang.IllegalArgumentException(
                                           );
                                     }
                                     transcoder.
                                       addTranscodingHint(
                                         org.apache.batik.transcoder.svg2svg.SVGTranscoder.
                                           KEY_DOCUMENT_WIDTH,
                                         new java.lang.Integer(
                                           arguments[index++]));
        }
        public java.lang.String getDescription() {
            return localizableSupport.
              formatMessage(
                "doc-width.description",
                null);
        }
        public DocWidthHandler() { super(
                                     ); }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471028784000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028784000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "KAQipCAAAA==");
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "/a5bJigjAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "UfxaVLnTBln9TTfJEtdQTiT+z95qf+z0");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("BOdQl4dUis8d2iFq7R2gLvE8d1PAp/H869u0/X5R/KuockcQlydY/uUJrK/8" +
       "GWCVG8lPguuTh7A++U5hxW8J649u0/bHRfEfosoVLzCcSCi+bZ1D9wd/VnTX" +
       "wPXaIbrX/t+j+9Zt2v5bUXw9qtxbohuo0uGW+Sl433gn8DKg0sUhtuJEzqM3" +
       "HITdH96Uv/j61Xve+7rw+/uzMUcHLC/TlXs2sWWdPhFx6v6SF6gbo2T68v5j" +
       "q1f+fS+q/NBtvkxGlbvK/5LT7+67/M+o8shNuwDmi7/TtH8SVR48TwvGLP9P" +
       "0/0AaMgJXVS5tL85RXLhIrANQFLc3uEdfcY4tVu/P0eSXTjrJI/X4eG3WodT" +
       "fvXpMx+NynPLR6cB4snht6kvvT5kP/ad1s/vT6XJlpTnxSj30JW79wfkykGL" +
       "EwVP3XK0o7EuDZ7//gO/fPnZI0/9wJ7hE909xduTNz8CRtheVB7ayv/Re//B" +
       "h37h9T8sP1f8X5KzhwFQLgAA");
}
