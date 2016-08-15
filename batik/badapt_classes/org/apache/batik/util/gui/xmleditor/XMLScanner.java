package org.apache.batik.util.gui.xmleditor;
public class XMLScanner {
    public static final int TEMP_ERROR_CONTEXT = -2;
    public static final int EOF_CONTEXT = -1;
    public static final int DEFAULT_CONTEXT = 0;
    public static final int COMMENT_CONTEXT = 1;
    public static final int ELEMENT_CONTEXT = 2;
    public static final int CHARACTER_DATA_CONTEXT = 3;
    public static final int ATTRIBUTE_NAME_CONTEXT = 4;
    public static final int ATTRIBUTE_VALUE_CONTEXT = 5;
    public static final int XML_DECLARATION_CONTEXT = 6;
    public static final int DOCTYPE_CONTEXT = 7;
    public static final int ENTITY_CONTEXT = 8;
    public static final int ELEMENT_DECLARATION_CONTEXT = 9;
    public static final int CDATA_CONTEXT = 10;
    public static final int PI_CONTEXT = 11;
    private int position;
    private java.lang.String string;
    private int current;
    private int scanValue;
    private int startOffset;
    public XMLScanner() { super();
                          reset(); }
    public void reset() { position = 0;
                          startOffset = 0; }
    public void setString(java.lang.String string) { this.string = string;
    }
    protected int nextChar() { try { current = (int) string.charAt(position);
                                     position++; }
                               catch (java.lang.Exception ex) { current =
                                                                  -1; }
                               return current; }
    protected int skipSpaces() { do  { nextChar(); }while(current != -1 &&
                                                            org.apache.batik.xml.XMLUtilities.
                                                            isXMLSpace(
                                                              (char)
                                                                current)); 
                                 return current; }
    public int getScanValue() { return scanValue; }
    public int getStartOffset() { return startOffset; }
    public int scan(int context) { nextChar();
                                   switch (context) { case XML_DECLARATION_CONTEXT:
                                                          scanValue =
                                                            scanXMLDeclaration(
                                                              );
                                                          break;
                                                      case DOCTYPE_CONTEXT:
                                                          scanValue =
                                                            scanDOCTYPE(
                                                              );
                                                          break;
                                                      case COMMENT_CONTEXT:
                                                          scanValue =
                                                            scanComment(
                                                              );
                                                          break;
                                                      case ELEMENT_CONTEXT:
                                                          scanValue =
                                                            scanElement(
                                                              );
                                                          break;
                                                      case ATTRIBUTE_NAME_CONTEXT:
                                                          scanValue =
                                                            scanAttributeName(
                                                              );
                                                          break;
                                                      case ATTRIBUTE_VALUE_CONTEXT:
                                                          scanValue =
                                                            scanAttributeValue(
                                                              );
                                                          break;
                                                      case CDATA_CONTEXT:
                                                          scanValue =
                                                            scanCDATA(
                                                              );
                                                          break;
                                                      default:
                                                          scanValue =
                                                            scanCharacterData(
                                                              );
                                                          break;
                                   }
                                   return position;
    }
    private int scanCharacterData() { while (current !=
                                               -1) {
                                          if (current ==
                                                '<') {
                                              nextChar(
                                                );
                                              if (current ==
                                                    '?') {
                                                  position =
                                                    position -
                                                      2;
                                                  return XML_DECLARATION_CONTEXT;
                                              }
                                              else
                                                  if (current ==
                                                        '!') {
                                                      nextChar(
                                                        );
                                                      if (current ==
                                                            'D') {
                                                          position =
                                                            position -
                                                              3;
                                                          return DOCTYPE_CONTEXT;
                                                      }
                                                      else
                                                          if (current ==
                                                                '-') {
                                                              nextChar(
                                                                );
                                                              if (current ==
                                                                    '-') {
                                                                  position =
                                                                    position -
                                                                      4;
                                                                  return COMMENT_CONTEXT;
                                                              }
                                                          }
                                                          else
                                                              if (current ==
                                                                    '[') {
                                                                  if (nextChar(
                                                                        ) ==
                                                                        'C') {
                                                                      if (nextChar(
                                                                            ) ==
                                                                            'D') {
                                                                          if (nextChar(
                                                                                ) ==
                                                                                'A') {
                                                                              if (nextChar(
                                                                                    ) ==
                                                                                    'T') {
                                                                                  if (nextChar(
                                                                                        ) ==
                                                                                        'A') {
                                                                                      if (nextChar(
                                                                                            ) ==
                                                                                            '[') {
                                                                                          position =
                                                                                            position -
                                                                                              9;
                                                                                          return CDATA_CONTEXT;
                                                                                      }
                                                                                  }
                                                                              }
                                                                          }
                                                                      }
                                                                  }
                                                              }
                                                  }
                                                  else {
                                                      position =
                                                        position -
                                                          2;
                                                      return ELEMENT_CONTEXT;
                                                  }
                                          }
                                          nextChar(
                                            );
                                      }
                                      if (current ==
                                            -1) {
                                          return EOF_CONTEXT;
                                      }
                                      return CHARACTER_DATA_CONTEXT;
    }
    private int scanXMLDeclaration() { position =
                                         position +
                                           2;
                                       while (current !=
                                                -1) {
                                           if (current ==
                                                 '?') {
                                               if (nextChar(
                                                     ) ==
                                                     '>') {
                                                   return CHARACTER_DATA_CONTEXT;
                                               }
                                               else {
                                                   return TEMP_ERROR_CONTEXT;
                                               }
                                           }
                                           nextChar(
                                             );
                                       }
                                       if (current ==
                                             -1) {
                                           return EOF_CONTEXT;
                                       }
                                       return XML_DECLARATION_CONTEXT;
    }
    private int scanDOCTYPE() { position =
                                  position +
                                    3;
                                boolean end =
                                  true;
                                while (current !=
                                         -1) {
                                    if (current ==
                                          '[') {
                                        end =
                                          false;
                                    }
                                    else
                                        if (current ==
                                              ']') {
                                            end =
                                              true;
                                        }
                                        else
                                            if (current ==
                                                  '>' &&
                                                  end ==
                                                  true) {
                                                return CHARACTER_DATA_CONTEXT;
                                            }
                                    nextChar(
                                      );
                                }
                                if (current ==
                                      -1) {
                                    return EOF_CONTEXT;
                                }
                                return DOCTYPE_CONTEXT;
    }
    private int scanComment() { while (current !=
                                         -1) {
                                    if (current ==
                                          '-') {
                                        if (nextChar(
                                              ) ==
                                              '-') {
                                            if (nextChar(
                                                  ) ==
                                                  '>') {
                                                return CHARACTER_DATA_CONTEXT;
                                            }
                                        }
                                    }
                                    nextChar(
                                      );
                                }
                                if (current ==
                                      -1) {
                                    return EOF_CONTEXT;
                                }
                                return COMMENT_CONTEXT;
    }
    private int scanElement() { while (current !=
                                         -1) {
                                    if (current ==
                                          '>') {
                                        return CHARACTER_DATA_CONTEXT;
                                    }
                                    else
                                        if (org.apache.batik.xml.XMLUtilities.
                                              isXMLSpace(
                                                (char)
                                                  current)) {
                                            return ATTRIBUTE_NAME_CONTEXT;
                                        }
                                    nextChar(
                                      );
                                }
                                if (current ==
                                      -1) {
                                    return EOF_CONTEXT;
                                }
                                return ELEMENT_CONTEXT;
    }
    private int scanAttributeName() { while (current !=
                                               -1) {
                                          if (current ==
                                                '=') {
                                              return ATTRIBUTE_VALUE_CONTEXT;
                                          }
                                          else
                                              if (current ==
                                                    '/') {
                                                  position--;
                                                  return ELEMENT_CONTEXT;
                                              }
                                              else
                                                  if (current ==
                                                        '>') {
                                                      position--;
                                                      return ELEMENT_CONTEXT;
                                                  }
                                          nextChar(
                                            );
                                      }
                                      if (current ==
                                            -1) {
                                          return EOF_CONTEXT;
                                      }
                                      return ATTRIBUTE_NAME_CONTEXT;
    }
    private int scanAttributeValue() { int delim =
                                         '\"';
                                       while (current !=
                                                -1) {
                                           if (current ==
                                                 '\"' ||
                                                 current ==
                                                 '\'') {
                                               delim =
                                                 current;
                                               break;
                                           }
                                           nextChar(
                                             );
                                       }
                                       nextChar(
                                         );
                                       while (current !=
                                                -1) {
                                           if (current ==
                                                 delim) {
                                               return ELEMENT_CONTEXT;
                                           }
                                           nextChar(
                                             );
                                       }
                                       if (current ==
                                             -1) {
                                           return EOF_CONTEXT;
                                       }
                                       return ATTRIBUTE_VALUE_CONTEXT;
    }
    private int scanCDATA() { while (current !=
                                       -1) {
                                  if (current ==
                                        ']') {
                                      if (nextChar(
                                            ) ==
                                            ']') {
                                          if (nextChar(
                                                ) ==
                                                '>') {
                                              return CHARACTER_DATA_CONTEXT;
                                          }
                                      }
                                  }
                                  nextChar(
                                    );
                              }
                              if (current ==
                                    -1) {
                                  return EOF_CONTEXT;
                              }
                              return CDATA_CONTEXT;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "wfDqgD8Irhlq6+xwA3c4jzByoan5QhdwxZg5ljc4JxUY8Dv9ofVdriP2YI6g" +
       "fPAsMDUucAFVgplH8gblpIKSCRAX20Lr3TA9miOmFfAsNBUudME0HjMn8sbk" +
       "pIKSGYl4/zk98Rd5DNoiU/siF4ClmHk2b4BOKiip8I8W8p/LEdJi80nknSCV" +
       "YeblvCE5qaCktKvNDc/Jz48Hj6bJNHOYEsOVjoewzO+zw/BQUqxq4gi8+9gQ" +
       "lLl0StNPxuz2v5mj/dOJEfBI4jeL/X8y7MfkrUxDnaTZay1+rGEiU2nqq7Lx" +
       "Fcdm+p9zNB39aYmpfImD6X9zNd1JGgaGj2kavHZlo/hMHhQvNTUtdbDzY1c7" +
       "naQpvNLxnMyOUbJZ+kmOls6E5xJT1yUOln7maqmTNLyW6ZTTqPFJKJut/3Kx" +
       "NW7pXJTUyf4VEdvnoRSdrOWMxCGeRmY5fcFj7+2Hdu87GOm8Z4nXPO7cBORS" +
       "Rb1IEkYEKaWrSuwp7fiunX2ztM7C3pxw2x8fbRxalcv3ECyrG+WLB/49O66R" +
       "hc4nJHZTntr9/vTQyuHNOXzamG1jyd7lfe1HnrlqPn+bl32gNQ7pMj7spgs1" +
       "p59KlGoCjWly+jlEQ3Jc2ecFjOHLzXFdbvdEy3NsLpE8tHcSZS2zHm97JrnU" +
       "1WAygZJCvD5hnNCsx+QawzE3UjJuRBEjSWf2VI428dzPl7GghR0leErTecHN" +
       "4koT3MrceXEStWE3j57wz/cZAQ0u5MzDpA5DkUCTcd1Ta5ExewzIqMY6DKyr" +
       "TESrXMjIsvCOVzWFCjwVIralt8KlTxcSlrrUXYrJIli3ZZiv/mGOnaj3Wfws" +
       "Hit+MJx3mFg63J3F05RJg5OoC9QrXOpaMPkibMD0raLaoyauh6QQ0TwGRFRi" +
       "3Qx4ek00ve5EZJs1TqIuYIMudR2YXEVJ+RBMmLTl26JizVhRgYvkehPP+typ" +
       "cBJ1gbvepW4DJiF4OUQqbPsDi4zesSJjEjwbTUQbcyfDSdQ5mvYx1IMujOD9" +
       "Fw8HCwpu7Gw8DIwBD0wcz5yvM8FcNwoPWTZ9TqIuMHWXuhgmMiUTkQKMl7CF" +
       "ErTVHOVsfChjxQceVx81QR3NnQ8nURfM17vU7cbkWkqqkY917cHVsOfCqwyJ" +
       "N0CLkOvGihAMoCdMVCdyJ8RJ1AX0zS5138FkL75SACHmWZmNiRvHkolXTDiv" +
       "5M6Ek6gL2jtd6u7CZL/JhF+JRhOvrBYTB8aSiTMmnDO5M+Ek6oL2sEvdfZj8" +
       "0GQCb/lmMvGjMQyfHq/Rp/GbExOOoi5oH3Kp+ykmx8zwmbyq3WG+f6XwMeoR" +
       "8n8RPj21Jqja3PlwEnXBfMKl7klMHjPDZ5KPbJuux8eKkGmAxrxH5nG4LOdG" +
       "iJOoC+gXXOp+g8kz5tkRO+C18fDs/4KHOOz0rZuneGVqasY9d+NuNv/AwcqS" +
       "2oO9r7IDk+T96fIgKRmMSVLqpZ6UfJGqCYMiY6/cuOLDri54XqOk4XPcigX4" +
       "yTwbslcN8TcomeYoTkkBpKnNT1FSk7U57ODwJ7XtHyipsrelpJD9prZ7F5iz" +
       "2lFSZGRSm7wHlkATzJ42rhykn68at6jixnH6jNSRYmdtNaMNcMqpWUPaaRP7" +
       "Hw2Jk6GY8X8awvyxg2s7rj37hXuMK52wO9m5E3spC5Ji43Yp6xRPl+Y69pbo" +
       "q2jNgnMTHhw/L3EON9Ew2JolMyxXJi0wK1T0rem2+456Y/La4+uHVjzx671F" +
       "L3mJZwPBrfWkDZn3zeJqTCOzNgQzb9r0cRq7iNm84M4dKxcPnnmDXewixs2c" +
       "mc7tw/zJwxtfvm3qoTovKWsjhaIcEeLsItzqHXK3wI9o/aRC1ANxMBF6ETkp" +
       "7RrPhAjb5YnyEOPFpLMiWYoXgimpz7zBlHmNulRStgvaKiUmR7CbiiAps0qM" +
       "kbEd0MVU1SZglZhDiekAJtfEcTTAH8PBdlVNXPAqX6uyOMBnewvimQ+fY1nM" +
       "ffYfzrBo/u00AAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "VkKh44hcm34Y6LZPtRp+IKPtmplV7LYg");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("d8DSF01I28LEjKpWgvnacpG6EiELM3VJZMEK/MTRIlZhWJVZ+iOpryh8HyWT" +
       "CmUhnUl9XFeS1To1KiEaLGB0Po6ZXq2ScA2nRsChj9coswpPfCTl+3ZxgjT8" +
       "qbesLFjDZURynkA0THBsgwC1eTazTseUWUp6ZbEU6E6lWK0hE4hWqsWYHC6y" +
       "FEHLbRp2KDnpN4PZyGrJLpzp1FLEuYw1Btm0EZRUfomarFOvMlWtl6p913Va" +
       "Yz0x07CiOioaJVBGJWk0Wznw0hO9VW8ULuZKVyV0OuxG2ZIc9+Ck2/AghcfL" +
       "GJsyzTZCiJaP8kF/ji2mtYm7Jrh+26cZczTxxobp+BmaNW3SYWObFyJjpfRM" +
       "yeFRfGqamB+Wlow1JbQSM5TKgmzYMljk6RZGRTNCFUUwcfebmj1kx31sOUbi" +
       "Ncc0XT1Zmc6gOJuUXWY2m8yyoOlBcamEYdiP5lt5f366Lca7Ntuj+0ee38LG" +
       "6DbpsTx4cn8jefM5Vzh2TPbQRvIm5wO781dhUHj4eieZN8dRvvjpF17SuC+V" +
       "z+5OqvWjwm2R5/+wra90+1BVF0FNT1//6A2zOch9cILq1z/9Jw+KH5x/7BTn" +
       "Qh85hvN4lf+Y+fI3O+9R/9bZwk3756led8T8aKFnjp6iuhDoURy44pGzVA/v" +
       "S3ZzNvN+8DR2km0c36I/6Ltr78+/b9v3m7RrHgQ8c/sJafkpojPnosItgR7q" +
       "0TW3oVeeqe3rzpnzb7QDfbiF/MWZm46Szf9m/uCO7AdvDNkzBxl+c8PqwRMY" +
       "P5QH9+b/sujR/p9RZy4eMLzvbTC8O3+Z/xHU3DFsnoYhAOUHXqSrka69Ya++" +
       "94S0p/LgsahwqwsGDT5XNicQ2QOKj79divmfSuyOInvKTjzz5Btyg09Iq+XB" +
       "lahwIbRMX/D3roAcYge9DXYX85fvAo+0Yyfd+PH4oRPSsDz4kahwhwG088jf" +
       "gAf8nnm7/HLrPdnxm9x4fr0T0pg8aEeFO3N+x/5PPGDYebsM7wHPR3YMP3Jj" +
       "GB4yMuyGyugEmpM84IHxzP/KPUZOeBvkNtnyY4mf2JH7xGnJvfqG3aeekJar" +
       "4pmPAj8j55UbFgXYqqClRMoxklffLsn8LOPLO5Iv33iS3glpyzxYRIW7c5Jj" +
       "hm6BaT+/irB3yOKApfV2WeaW5tUdy1dvPMuPn5D2bB6s8r/1AcvdUa1j9JIb" +
       "Qe/bO3rfvvH0njsh7a/nwad39HDPcfZOeRzQ+2s3gt73dvS+d+Pp/cwJaS/m" +
       "wfM7evn909fT++kbYGfOnN2W3X7fWHp//4S0f5gHf3dnZ7AIuGnTONLZnVt9" +
       "iOTfuwF25sz9O5L333iS/+SEtJfz4Od2dmaf5LVm/J9/uyzfCQDvLkaduc7t" +
       "r7fD8pdPSPuXefBLu1NNm3N/x8j909OQS4Hjd3DZML859cDrrjZvr+OqX3np" +
       "4q33vyT9+819u/0rs7fRhVtnsW0fvuhyKH7OD/SZuSF82/bai79h8UpUeOJN" +
       "XIQENPfjm37419vivxoV3nnd4lHhJhAezv6NqHDvNbMDjyL/Opz3m1Hh0vG8" +
       "YD23+T6c71tAcgf5osK5beRwlt8BSECWPPpv/I3oj57d294sSrenKR84pG7b" +
       "bYW736gjD20QPHFkWb+5xL63BI+319ivql99iWI//n3kS9uLh2AOzrK8llvp" +
       "wvntHchNpfky/rHr1rZX1znyqR/c+Yu3Pbm35XDnFvCB6h/C9si1b/kRjh9t" +
       "7uVl/+L+f/aBn3/pDzb3k/4fWvZYwV1AAAA=");
}
