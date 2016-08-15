package org.apache.batik.ext.awt.image.codec.tiff;
public class TIFFRegistryEntry extends org.apache.batik.ext.awt.image.spi.MagicNumberRegistryEntry {
    static final byte[] sig1 = { (byte) 73, (byte) 73, 42, 0 };
    static final byte[] sig2 = { (byte) 77, (byte) 77, 0, 42 };
    static org.apache.batik.ext.awt.image.spi.MagicNumberRegistryEntry.MagicNumber[]
      magicNumbers =
      { new org.apache.batik.ext.awt.image.spi.MagicNumberRegistryEntry.MagicNumber(
      0,
      sig1),
    new org.apache.batik.ext.awt.image.spi.MagicNumberRegistryEntry.MagicNumber(
      0,
      sig2) };
    static final java.lang.String[] exts = { "tiff", "tif" };
    static final java.lang.String[] mimeTypes = { "image/tiff",
    "image/tif" };
    public TIFFRegistryEntry() { super("TIFF", exts, mimeTypes,
                                       magicNumbers); }
    public org.apache.batik.ext.awt.image.renderable.Filter handleStream(java.io.InputStream inIS,
                                                                         org.apache.batik.util.ParsedURL origURL,
                                                                         boolean needRawData) {
        final org.apache.batik.ext.awt.image.renderable.DeferRable dr =
          new org.apache.batik.ext.awt.image.renderable.DeferRable(
          );
        final java.io.InputStream is =
          inIS;
        final java.lang.String errCode;
        final java.lang.Object[] errParam;
        if (origURL !=
              null) {
            errCode =
              ERR_URL_FORMAT_UNREADABLE;
            errParam =
              (new java.lang.Object[] { "TIFF",
               origURL });
        }
        else {
            errCode =
              ERR_STREAM_FORMAT_UNREADABLE;
            errParam =
              (new java.lang.Object[] { "TIFF" });
        }
        java.lang.Thread t =
          new java.lang.Thread(
          ) {
            public void run() {
                org.apache.batik.ext.awt.image.renderable.Filter filt;
                try {
                    org.apache.batik.ext.awt.image.codec.tiff.TIFFDecodeParam param =
                      new org.apache.batik.ext.awt.image.codec.tiff.TIFFDecodeParam(
                      );
                    org.apache.batik.ext.awt.image.codec.util.SeekableStream ss =
                      org.apache.batik.ext.awt.image.codec.util.SeekableStream.
                      wrapInputStream(
                        is,
                        true);
                    org.apache.batik.ext.awt.image.rendered.CachableRed cr =
                      new org.apache.batik.ext.awt.image.codec.tiff.TIFFImage(
                      ss,
                      param,
                      0);
                    cr =
                      new org.apache.batik.ext.awt.image.rendered.Any2sRGBRed(
                        cr);
                    filt =
                      new org.apache.batik.ext.awt.image.renderable.RedRable(
                        cr);
                }
                catch (java.io.IOException ioe) {
                    filt =
                      org.apache.batik.ext.awt.image.spi.ImageTagRegistry.
                        getBrokenLinkImage(
                          TIFFRegistryEntry.this,
                          errCode,
                          errParam);
                }
                catch (java.lang.ThreadDeath td) {
                    filt =
                      org.apache.batik.ext.awt.image.spi.ImageTagRegistry.
                        getBrokenLinkImage(
                          TIFFRegistryEntry.this,
                          errCode,
                          errParam);
                    dr.
                      setSource(
                        filt);
                    throw td;
                }
                catch (java.lang.Throwable t) {
                    filt =
                      org.apache.batik.ext.awt.image.spi.ImageTagRegistry.
                        getBrokenLinkImage(
                          TIFFRegistryEntry.this,
                          errCode,
                          errParam);
                }
                dr.
                  setSource(
                    filt);
            }
        };
        t.
          start(
            );
        return dr;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1ZaXAcxRXuXcm6ZR34wtiyLctOSZhdm5uSQ7CFZMtZyYpl" +
       "u4iMkWdne3fHnp0ZZnqllYk5nKJwSIUixlwp0I9gYkMZTFGQkAqHU1Q4iqOK" +
       "IyGEADkJBChwUhAqJiHvdc/sHHvIhoq3anpme957/V736++913PoQzLNMkkb" +
       "1ViETRjUivRqbEgyLZroUSXL2gh9o/KtFdI/L3t38IIwqRoh09OSNSBLFu1T" +
       "qJqwRsh8RbOYpMnUGqQ0gRxDJrWoOSYxRddGyEzF6s8YqiIrbEBPUCTYLJkx" +
       "0iIxZirxLKP9tgBG5sdAkyjXJLoq+Lo7Rhpk3Zhwyed4yHs8b5Ay445lMdIc" +
       "2y6NSdEsU9RoTLFYd84kpxu6OpFSdRahORbZrp5jT8G62DkFU9D+QNOnx25M" +
       "N/MpOEXSNJ1x86wN1NLVMZqIkSa3t1elGetyciWpiJF6DzEjHTFn0CgMGoVB" +
       "HWtdKtC+kWrZTI/OzWGOpCpDRoUYWeQXYkimlLHFDHGdQUINs23nzGDtwry1" +
       "wsoCE28+Pbrv1suaH6wgTSOkSdGGUR0ZlGAwyAhMKM3EqWmtSiRoYoS0aLDY" +
       "w9RUJFXZaa90q6WkNIllYfmdacHOrEFNPqY7V7COYJuZlZlu5s1Lcoey/01L" +
       "qlIKbJ3l2ios7MN+MLBOAcXMpAR+Z7NU7lC0BCMLghx5Gzu+CQTAWp2hLK3n" +
       "h6rUJOggrcJFVElLRYfB9bQUkE7TwQFNRuaWFIpzbUjyDilFR9EjA3RD4hVQ" +
       "1fKJQBZGZgbJuCRYpbmBVfKsz4eDK2+4QlurhUkIdE5QWUX964GpLcC0gSap" +
       "SWEfCMaGrtgt0qzH9oQJAeKZAWJB87PvHL1oWduRZwTNaUVo1se3U5mNyvvj" +
       "01+a19N5QQWqUWPoloKL77Oc77Ih+013zgCEmZWXiC8jzssjG5769tX30vfD" +
       "pK6fVMm6ms2AH7XIesZQVGquoRo1JUYT/aSWaoke/r6fVMNzTNGo6F2fTFqU" +
       "9ZNKlXdV6fw/TFESROAU1cGzoiV159mQWJo/5wxCSDVcpAGupUT8+J0RLZrW" +
       "MzQqyZKmaHp0yNTRfisKiBOHuU1H4+D1O6KWnjXBBaO6mYpK4Adpar/AnSmN" +
       "s6iSgeWPyoBGcpQpyWR0Y39f3waaAhAyJwBtzYkI+p1x0kfM4RycMh4KwfLM" +
       "C4KDCvtqra4mqDkq78uu7j16/+hzwvFws9izx0g3KBERSkS4EhxKQYkIVyLC" +
       "lYigEpECJUgoxMeegcoIt4BF3QHwADQNncNb123b014B/miMV8KKIGm7L071" +
       "uBjiAP+ofLi1ceeit1Y8GSaVMdIqySwrqRh2VpkpADR5h73nG+IQwdxAstAT" +
       "SDACmrpME4BjpQKKLaVGH6Mm9jMywyPBCXO4oaOlg0xR/cmR28av2XzV8jAJ" +
       "+2MHDjkNYA/ZhxDx88jeEcSMYnKbrnv308O37NJd9PAFIyeGFnCiDe1B7whO" +
       "z6jctVB6ePSxXR182msB3ZkEuxGAsy04hg+cuh2gR1tqwOCkbmYkFV85c1zH" +
       "0qY+7vZwt23hzzPALepxt86D6yx7+/I7vp1lYDtbuDn6WcAKHki+Pmzc+dsX" +
       "3zuLT7cTc5o8ycIwZd0enENhrRzRWly33WhSCnRv3jZ0080fXreF+yxQLC42" +
       "YAe2PYBvsIQwzdc+c/nrb7+1/9Ww6+cMAn02DvlSLm8k9pO6MkbCaEtdfQAn" +
       "VUAO9JqOTRr4p5JUpLhKcWN93rRkxcMf3NAs/ECFHseNlk0twO0/dTW5+rnL" +
       "/tXGxYRkjNPunLlkAvxPcSWvMk1pAvXIXfPy/Nuflu6EMALQbSk7KUdjwueA" +
       "8EU7h9u/nLdnB96dh80Sy+v8/v3lyadG5Rtf/bhx88ePH+Xa+hMy71oPSEa3" +
       "cC9sluZA/OwgOK2VrDTQnX1k8NJm9cgxkDgCEmUAZGu9CXCZ83mGTT2t+ne/" +
       "fHLWtpcqSLiP1Km6lOiT+CYjteDd1EoD0uaMb1wkFne8BppmbiopML6gAyd4" +
       "QfGl680YjE/2zkdmP7TywORb3MsMIeM0zo/Z/zwfqvK03t3Y975y3q8P/PCW" +
       "cZEYdJZGswDfnH+vV+O7//RZwZRzHCuStAT4R6KH7pjbc+H7nN8FFOTuyBUG" +
       "LABll/fMezOfhNurfhUm1SOkWbbT6M2SmsVtOgKpo+Xk1pBq+97700CR83Tn" +
       "AXNeEMw8wwahzA2U8IzU+NwYQK8WXMJVcHXaG7sziF4hwh/6OcvXeNuFzRl8" +
       "+cIAFhbP0xmMrmiSGgCN5jKyGe671Ap//YexazgbtxjfqSI5vLT+qSesu955" +
       "UPhAexHiQMZ58ECN/Ebmqb8IhlOLMAi6mQejP9j82vbnOfrWYEje6EyUJ+BC" +
       "6PZAf3PeQER9shAQ81Fhn7gzIn/FPCpuKglIoFaDOsOyqRgMSoFebUwxdS2D" +
       "ptjp2skYBiFoSek951mjyZ8sfvGqycV/5IBUo1jgmTBvRSoKD8/Hh95+/+XG" +
       "+ffzoF2J029Pvb8UK6y0fAUUX5UmbDblrOLuMWQqGQifY7Z7nDm0Td7TMcTd" +
       "A/mGxZJ+Ab8QXP/FC5cSO8SStvbYFcHCfEmAOFYWkAKDRne1vr3jjnfvEz4Z" +
       "RJ8AMd2z7/ovIjfsE1FS1JWLC0o7L4+oLYWHYrMVtVtUbhTO0fe3w7t+cXDX" +
       "dUKrVn+V1KtlM/f95j/PR277w7NFku/K+ASj+XgQymfJM/wrICy6+HtNj97Y" +
       "WtEHa91ParKacnmW9if8MFVtZeOeDegWrC502bbhyjAS6nKCiVcB/N8j3MEG" +
       "L7UEeOFjBJtBLnsrgJlKtRRLc8pRexrxBvBWAV6IjyOeIcNCDv8/h9l5BiI3" +
       "1M26RjFlcd6JKkPRI/kzC3hZqLxJ5vui4QB3dDe0vDl9759/3pFafSLlBfa1" +
       "TVFA4P8F4AFdpf05qMrTu/8+d+OF6W0nUCksCPhjUOQ9A4eeXbNU3hvmxyIi" +
       "5hUcp/iZuv0uVGdSljU1v9MsFt7AV0+4Ajan8/Utk+NdXebdbmx2QdCTcaGF" +
       "X5Qhv7YwbcKOVYYnw7JdAP8qdtGA7fnYrBOe0l0yRespDOlddtjtKhHSry+z" +
       "KwbEriiM5aWEilh+Jj5vDOj+/ePXnRdTK+GK2MMsK6H73uK688kbKFK3LCsh" +
       "j8GukFKKPJjlZ4uc8Vv+qcQof67Nfq6IBv+Pg5LtBk1F1w31rjlpRzNlRhQz" +
       "eAk2t+ccBFszxVmLZSiRAXcyfVI7PC8Mwzg+p7/pBJ3+fLiW2yu1vITj/PjL" +
       "OH0poeD0MAW219hh4RIjP2HNbjgQ57nFQ5Xh6HbfcYYpbPhhIue6pzAe4V8e" +
       "q8aKR8cJgwu6B5sry6DWQ2Xe/RSbB7H5rtCiDO0jXxH97jpBR7gYrhX2mq0o" +
       "4QiPfRlHKCWUkdqMkqH5Q6KDAQMeL2NAzhOR8iPyXxUJHAp7RvSU0AQzvfml" +
       "zu15lrd/977JxPq7VzgJL2STtUw3zlDpGFU9omz3yKvRiuLbiIgnxLl7Z9M1" +
       "NGBBHnpLsQb8pYIrUOFPpSBd6teMLIPtQ+00At4tKAAicabPPyht2hDjdFv4" +
       "VskVy+Sq47quUkkr7nvcpJfKePPvsXkeIkda0hIq9eu2fAqQhCI1AfUD5H6R" +
       "PkWFssZ1khem8vLyxzD2jmKkpeCkG49o5hR8fhOfjOT7J5tqZk9uek0UYc5n" +
       "nQbIDZNZVfUeInieqwyTJsU+bRBHCgJS3mGk87iP5AE+8cZN+avgf4+RjuPh" +
       "x8QL717eDxhpK88LXPzu5fqIkTmluCDph9ZL/Q9I5ItRAyVGAg/lJ4D/QUoY" +
       "n9+9dJ8xUufSQQUiHrwkx0A6kODj54bjaFN9+SgXjXMhP3zkXXDmVC7oQZzF" +
       "vkqBfwN2svqs+Ao8Kh+eXDd4xdFz7xan27Iq7dyJUuqh1BMH7fnKYFFJaY6s" +
       "qrWdx6Y/ULvEwbAWobALQKd59iiATchAt58bOPq1OvInwK/vX/n4C3uqXobK" +
       "dgsJSYA5WwqP3nJGFsB1S6ywpIUqip9Jd3f+aOLCZcmP3uCHm0QUcfNK04/K" +
       "rx7Y+sreOfvbwqS+HzwSACHHzwQvntA2UHnMHCGNitWbAxVBCtSKvnp5Ou5Q" +
       "CbMJPi/2dDbme/HbCCPthWcFhV+U6lR9nJqr9ayWQDFQcde7PU6F6CuusoYR" +
       "YHB7PIcxaYG3uBrguqOxAcNwjlJqnzA4UiklA3+IH+Uo+NT8P0VlFBUfIgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "Dzcdyv7+12+0MnbmkAewoguHz4qTNE9c");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("OBG7P8Wpfe2Vaw++5xX53+538o9OWj7EQg+ameuePvhw6v3+MDZMu1T7of0x" +
       "iLB8fCuFnn/Tp+RS6GrxKHX44335/5ZCN99M+WIPsXieLvt6Cj1977KgVPk8" +
       "Xep/pNATdyuVQldAepr6T1PonXeiBpTFpsQpyj9LoevnKUH95fM03Z+n0MMn" +
       "dCl0//7lFMklCHAHJMXrpfDIoN7oMOK9NrfyS2c9/tjUHn8jUzsFEs+e2fQu" +
       "j2UfbVBn+4PZt7WvvzIYfvL1xlf2Z+Q0V9ntCi4PstAD++N6x5vc77srtyNe" +
       "9/ee/+6jv/TQc0ew8+he4BPMOCXbM3c+kNbxwrQ8Qrb7x+/5hx/5+Vd+v1z3" +
       "/r+oBiMhLy8AAA==");
}
