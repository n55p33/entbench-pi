package org.apache.batik.swing.svg;
public class SVGUpdateOverlay implements org.apache.batik.swing.gvt.Overlay {
    java.util.List rects = new java.util.LinkedList();
    int size;
    int updateCount;
    int[] counts;
    public SVGUpdateOverlay(int size, int numUpdates) { super();
                                                        this.size = size;
                                                        counts = (new int[numUpdates]);
    }
    public void addRect(java.awt.Rectangle r) { rects.add(r);
                                                if (rects.size() >
                                                      size) rects.
                                                              remove(
                                                                0);
                                                updateCount++; }
    public void endUpdate() { int i = 0;
                              for (; i < counts.length - 1; i++) {
                                  counts[i] =
                                    counts[i +
                                             1];
                              }
                              counts[i] = updateCount;
                              updateCount = 0;
                              int num = rects.size();
                              for (i = counts.length - 1; i >= 0;
                                   i--) { if (counts[i] > num) { counts[i] =
                                                                   num;
                                          }
                                          num -= counts[i]; }
                              counts[0] += num; }
    public void paint(java.awt.Graphics g) { java.util.Iterator i =
                                               rects.
                                               iterator(
                                                 );
                                             int count = 0;
                                             int idx = 0;
                                             int group = 0;
                                             while (group < counts.
                                                              length -
                                                      1 &&
                                                      idx ==
                                                      counts[group])
                                                 group++;
                                             int cmax = counts.length -
                                               1;
                                             while (i.hasNext()) {
                                                 java.awt.Rectangle r =
                                                   (java.awt.Rectangle)
                                                     i.
                                                     next(
                                                       );
                                                 java.awt.Color c;
                                                 c =
                                                   new java.awt.Color(
                                                     1.0F,
                                                     (cmax -
                                                        group) /
                                                       (float)
                                                         cmax,
                                                     0,
                                                     (count +
                                                        1.0F) /
                                                       rects.
                                                       size(
                                                         ));
                                                 g.
                                                   setColor(
                                                     c);
                                                 g.
                                                   drawRect(
                                                     r.
                                                       x,
                                                     r.
                                                       y,
                                                     r.
                                                       width,
                                                     r.
                                                       height);
                                                 count++;
                                                 idx++;
                                                 while (group <
                                                          counts.
                                                            length -
                                                          1 &&
                                                          idx ==
                                                          counts[group]) {
                                                     group++;
                                                     idx =
                                                       0;
                                                 }
                                             } }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAALUZC3BU1fXu5kNIyFcIGCBACGKC7qrVIo2iEAPELpAmmJku" +
                                                              "n/Dy9m72kbfvPd67m2xi8TftiO2UsRbROpLOtChqUaxTp7VWS+vUz2htVVq1" +
                                                              "jmJrx2qVUcbRdmpbe8697+377IdhLDvz7r6995xz7/mfe/bQcVJhmaSVaizC" +
                                                              "JgxqRXo01ieZFk10q5JlbYK5Ifm2Mumjbe9sWBEmlXFSl5Ks9bJk0TUKVRNW" +
                                                              "nMxXNItJmkytDZQmEKPPpBY1xySm6FqczFKs3rShKrLC1usJigCDkhkjjRJj" +
                                                              "pjKcYbTXJsDI/BicJMpPEl0VXO6KkRmybky44HM84N2eFYRMu3tZjDTEdkhj" +
                                                              "UjTDFDUaUyzWlTXJMkNXJ0ZUnUVolkV2qBfZIrgydlGeCNoerP/k05tTDVwE" +
                                                              "Z0iapjPOntVPLV0do4kYqXdne1SatnaSa0hZjNR4gBlpjzmbRmHTKGzqcOtC" +
                                                              "welrqZZJd+ucHeZQqjRkPBAji/xEDMmU0jaZPn5moFDFbN45MnC7MMet4DKP" +
                                                              "xVuXRffetq3hoTJSHyf1ijaAx5HhEAw2iYNAaXqYmtaqRIIm4qRRA2UPUFOR" +
                                                              "VGXS1nSTpYxoEsuA+h2x4GTGoCbf05UV6BF4MzMy080ce0luUPaviqQqjQCv" +
                                                              "zS6vgsM1OA8MVitwMDMpgd3ZKOWjipZgZEEQI8dj+5cBAFCnpSlL6bmtyjUJ" +
                                                              "JkiTMBFV0kaiA2B62giAVuhggCYjLUWJoqwNSR6VRugQWmQArk8sAdR0LghE" +
                                                              "YWRWEIxTAi21BLTk0c/xDZfsuVpbp4VJCM6coLKK568BpNYAUj9NUpOCHwjE" +
                                                              "GZ2xfVLzY7vDhADwrACwgPnp105cfk7rkacFzNwCMBuHd1CZDckHhutemNfd" +
                                                              "saIMj1Fl6JaCyvdxzr2sz17pyhoQYZpzFHEx4iwe6X/yq9fdR98Lk+peUinr" +
                                                              "aiYNdtQo62lDUam5lmrUlBhN9JLpVEt08/VeMg3eY4pGxezGZNKirJeUq3yq" +
                                                              "Uue/QURJIIEiqoZ3RUvqzrshsRR/zxqEkGnwkPPgWUrEh38zsi2a0tM0KsmS" +
                                                              "pmh6tM/UkX8rChFnGGSbig6D1Y9GLT1jgglGdXMkKoEdpKizMA4WFLXGwJgG" +
                                                              "115lJICNjWPUVKWJCNqZcdp3yCKPZ4yHQiD+eUHnV8Fv1ulqgppD8t7M6p4T" +
                                                              "Dww9KwwLncGWDiPLYNOI2DTCN43wTSOwaSS4KQmF+F4zcXOhZlDSKLg7xNsZ" +
                                                              "HQNbr9y+u60M7MsYLwcJI2ibL+90uzHBCeRD8uGm2slFb5z/RJiUx0iTJLOM" +
                                                              "pGIaWWWOQICSR20fnjEMGclNDAs9iQEzmqnLNAFxqViCsKlU6cAKzjMy00PB" +
                                                              "SVvooNHiSaPg+cmR28evH7z2vDAJ+3MBblkBYQzR+zCC5yJ1ezAGFKJbf+M7" +
                                                              "nxzet0t3o4EvuTg5MQ8TeWgLWkNQPENy50Lp4aHHdrVzsU+HaM0k8C4IhK3B" +
                                                              "PXzBpssJ3MhLFTCc1M20pOKSI+NqljL1cXeGm2kjf58JZlGD3jcXnmW2O/Jv" +
                                                              "XG02cJwtzBrtLMAFTwyXDhj7X3n+3S9wcTs5pN6T/Aco6/LELSTWxCNUo2u2" +
                                                              "m0xKAe712/u+e+vxGzdzmwWIxYU2bMexG+IVqBDE/I2nd7567I0DR8OunTNI" +
                                                              "3JlhqH+yOSZxnlSXYBJ2O8s9D8Q9FSIDWk37VRrYp5JUpGGVomP9u37J+Q+/" +
                                                              "v6dB2IEKM44ZnXNyAu78mavJdc9u+0crJxOSMe+6MnPBRDA/w6W8yjSlCTxH" +
                                                              "9voX53/vKWk/pAUIxZYySXl0DXMZhP2+jv40kBm2wC+VNKhhzE5UF/Rtl3e3" +
                                                              "9/1VJKEzCyAIuFn3RL89+PKO57iSq9DzcR75rvX4NUQIj4U1COF/Bp8QPP/F" +
                                                              "B4WOEyLgN3XbWWdhLu0YRhZO3lGiTvQzEN3VdGz0znfuFwwE03IAmO7e+83P" +
                                                              "Inv2Cs2J2mVxXvngxRH1i2AHhxV4ukWlduEYa/52eNej9+y6UZyqyZ+Je6DQ" +
                                                              "vP+P/3kucvubzxRIAGWKXX9eiKacC9wz/boRDF1xU/0vbm4qWwMxo5dUZTRl" +
                                                              "Z4b2JrwUofSyMsMeZbk1EZ/wsoaKYSTUCTrAiYv5eBE/y3m5ExF+IsLX1uGw" +
                                                              "xPLGT7++PCX2kHzz0Q9rBz98/ATn2V+je8PFeskQAm/E4SwU+OxgflsnWSmA" +
                                                              "u/DIhi0N6pFPgWIcKMqQs62NJmTYrC+42NAV0/70qyeat79QRsJrSLWqS4k1" +
                                                              "Eo/TZDoESGqlIDlnjcsuF/FhvAqGBs4qyWM+bwJ9dEFh7+9JG4z76+TPZv/k" +
                                                              "koNTb/BAZQgaczl+OdYLvsTMb3pubrjvpeV/OPidfePCnkp4RwBvzr82qsM3" +
                                                              "/OWfeSLnqbCAwwTw49FDd7Z0r3yP47s5CbHbs/k1DuR1F/eC+9Ifh9sqfxMm" +
                                                              "0+KkQbZvVoOSmsFIH4fbhOVct+D25Vv33wxEGdyVy7nzgh7r2TaYDb2OUM58" +
                                                              "Rt/ozw1t8Jxt54azgwkwRPhLnKMs5WMnDud67SFHqrwEKUYqTCw5QePzC0Tb" +
                                                              "fmmc3z+G5C1LG5rbV3zUZge2ArCei8qeR38ejy9tkAVwobgfuKDcc7BKfi39" +
                                                              "JI/7eK7lOQ7q8MBN8Nxrc3CviNVbPmfpDGhwY4ZACRrdpKRpAm/seFC7ND+t" +
                                                              "9HkQ8TmYK+gfjaqrPrj47kuF7BYV8S0X/pGvvPnC/snDh0ToxlQIRXuxHkN+" +
                                                              "YwOrwSUlKlpXqR+v/dKRd98a3OroqA6HhLC1OYzUeYOiqEHUYN7Anz12+YZj" +
                                                              "Lw6bBYlY0Ui3yW/OLfB02MbQUcQzdgrPwGFrvjMUw2aibOHJJnBI8zQckgsC" +
                                                              "sk1Nhl+iuvWMxgrtPXGKezfC02nv3Vlk710lBVQMm+ENHU5pWYVDAK8FhbVs" +
                                                              "qXnyl9YP337IsZZhv0fjGW12xDcjmz+nx6GlS+MsOkL1dLQPbvhwfxthKceh" +
                                                              "Tyd59OcSTuQRy9Tdi5+/dmrxn3mJUKVYkCugSi3Q9vHgfHjo2Hsv1s5/gN/E" +
                                                              "uIfbtZO/X5bfDvN1ubgW6nH4uiin8oo6bkoCwLaSbxVOMGF8jUDqSCqapHJq" +
                                                              "K8A0VC4Q/LUSh5sMty5xLgF2rBDXB8ymkW5V1yjeRJw10TxQ9EiutQiL2bzD" +
                                                              "+vIVBND1nFU33b9ed8tbj7SPrD6VrgHOtZ6kL4C/F4C+OourO3iUp274e8um" +
                                                              "lantp9AAWBCwhiDJe9cfembtWfItYd69FHVIXtfTj9Tlrz6qTcoypuYvvBe7" +
                                                              "5nGTGyCWcQWXqLv3l1j7Pg53gK3IqGhhFyXAf5BfyuJEv+Gpekslk2tKxMqs" +
                                                              "h6VcNOKfShJo/nlinqcuDjk22lakKTYyxiJ2LwxDwvxirVx+KTtww96pxMa7" +
                                                              "znci5OUMCn/dOFelY1T17FrG3/f5+yPtRLQsifPtjfGuTALM5roOxVADmgn5" +
                                                              "2W7irglBMNIPoRO8FxwTlx4uodBHcHiQkWlSIoFYHKiLW5TQx2WQdcd0JeHq" +
                                                              "8Mcny3elrz7CXgoJDZtKy23Ol5+60IqhluD+qRJrz+Dwa8Y72KKNihOPunJ4" +
                                                              "4nTJYRE8vTYzvacuh2KopY2nMWc8a03JSCmyxbc6WkJCr+DwO4gdBlzzWEA6" +
                                                              "v/9/SCfLSEOwi4135zl5f5WJv3fkB6bqq2ZPXfWyyMXOXzAzIEEkM6rqvd15" +
                                                              "3isNkyYVztIMcdcTHY03GWkp3l5n4Plj4uZ4TMC/xUhzYXiQEf/2Qr8NvAWh" +
                                                              "AY5/e+HeZaTahYM8Ll68IO/DWQAEX48bjkIb3CQursTZkCdq2TLnqpp1MlXl" +
                                                              "ULwtVsyr/I9NJwdm+uwrz+GpKzdcfeKLd4kWr6xKk5NIpQYqHtFtzuXRRUWp" +
                                                              "ObQq13V8Wvfg9CVOFG4UB3a9YK7HIPvBng20j5ZA/9Nqz7VBXz1wyeO/3V35" +
                                                              "IlR4m0lIgmJnc37zIGtkID1sjuU30aDm4I3Zro47Jlaek/zgNd6eIaLkmVcc" +
                                                              "fkg+enDrS7fMOdAaJjW9pAISDM3yrsYVExoE3jEzTmoVqycLRwQqUFn5OnR1" +
                                                              "aMoS/uXJ5WKLszY3i38QQN7Lb07m/61Srerj1FwN94QEkoE6tcad8f3jartH" +
                                                              "dcYwAgjujKd4vUJkDdQG2ONQbL1hOL3bMDO4R/cULRJCPFL14Fvof8bYQM/0" +
                                                              "IAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "z9yzteO2rgyf/9ajn33oXccg+Oie4VPX");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      "PsPbO+5+j6Zne1F58yX/12/9l+/5J6/8Ybnx/hdZmqeMtisAAA==";
}
