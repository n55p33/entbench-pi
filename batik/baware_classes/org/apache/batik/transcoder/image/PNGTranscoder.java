package org.apache.batik.transcoder.image;
public class PNGTranscoder extends org.apache.batik.transcoder.image.ImageTranscoder implements ent.runtime.ENT_Attributable {
    public int ENT_attribute() { return org.apache.batik.apps.rasterizer.EntMode.
                                          LOW_MODE; }
    public PNGTranscoder() { super();
                             hints.put(KEY_FORCE_TRANSPARENT_WHITE,
                                       java.lang.Boolean.
                                         FALSE); }
    public org.apache.batik.bridge.UserAgent getUserAgent() { return this.
                                                                       userAgent;
    }
    public java.awt.image.BufferedImage createImage(int width,
                                                    int height) {
        return new java.awt.image.BufferedImage(
          width,
          height,
          java.awt.image.BufferedImage.
            TYPE_INT_ARGB);
    }
    private org.apache.batik.transcoder.image.PNGTranscoder.WriteAdapter getWriteAdapter(java.lang.String className) {
        org.apache.batik.transcoder.image.PNGTranscoder.WriteAdapter adapter;
        try {
            java.lang.Class clazz =
              java.lang.Class.
              forName(
                className);
            adapter =
              (org.apache.batik.transcoder.image.PNGTranscoder.WriteAdapter)
                clazz.
                newInstance(
                  );
            return adapter;
        }
        catch (java.lang.ClassNotFoundException e) {
            return null;
        }
        catch (java.lang.InstantiationException e) {
            return null;
        }
        catch (java.lang.IllegalAccessException e) {
            return null;
        }
    }
    public void writeImage(java.awt.image.BufferedImage img,
                           org.apache.batik.transcoder.TranscoderOutput output)
          throws org.apache.batik.transcoder.TranscoderException {
        java.io.OutputStream ostream =
          output.
          getOutputStream(
            );
        if (ostream ==
              null) {
            throw new org.apache.batik.transcoder.TranscoderException(
              org.apache.batik.transcoder.image.resources.Messages.
                formatMessage(
                  "png.badoutput",
                  null));
        }
        boolean forceTransparentWhite =
          false;
        if (hints.
              containsKey(
                org.apache.batik.transcoder.image.PNGTranscoder.
                  KEY_FORCE_TRANSPARENT_WHITE)) {
            forceTransparentWhite =
              ((java.lang.Boolean)
                 hints.
                 get(
                   org.apache.batik.transcoder.image.PNGTranscoder.
                     KEY_FORCE_TRANSPARENT_WHITE)).
                booleanValue(
                  );
        }
        if (forceTransparentWhite) {
            java.awt.image.SinglePixelPackedSampleModel sppsm;
            sppsm =
              (java.awt.image.SinglePixelPackedSampleModel)
                img.
                getSampleModel(
                  );
            forceTransparentWhite(
              img,
              sppsm);
        }
        org.apache.batik.transcoder.image.PNGTranscoder.WriteAdapter adapter =
          getWriteAdapter(
            ("org.apache.batik.ext.awt.image.codec.png.PNGTranscoderIntern" +
             "alCodecWriteAdapter"));
        if (adapter ==
              null) {
            adapter =
              getWriteAdapter(
                ("org.apache.batik.transcoder.image.PNGTranscoderImageIOWriteA" +
                 "dapter"));
        }
        if (adapter ==
              null) {
            throw new org.apache.batik.transcoder.TranscoderException(
              "Could not write PNG file because no WriteAdapter is availble");
        }
        adapter.
          writeImage(
            this,
            img,
            output);
    }
    public static interface WriteAdapter {
        void writeImage(org.apache.batik.transcoder.image.PNGTranscoder transcoder,
                        java.awt.image.BufferedImage img,
                        org.apache.batik.transcoder.TranscoderOutput output)
              throws org.apache.batik.transcoder.TranscoderException;
        java.lang.String jlc$CompilerVersion$jl7 =
          "2.7.0";
        long jlc$SourceLastModified$jl7 =
          1471109864000L;
        java.lang.String jlc$ClassType$jl7 =
          ("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");
        java.lang.String jlc$CompilerVersion$jl5 =
          "2.7.0";
        long jlc$SourceLastModified$jl5 =
          1471109864000L;
        java.lang.String jlc$ClassType$jl5 =
          ("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" +
           "lw5bD0NsAH3/9WhnVa8TkTi9SWM6kerVndBW9sPvsfAeuu7R3swU7nz1pvBO" +
           "EAxfhvIO574fwaFLmdEfKTam5a+jnW4A3YPTtdHoynjaJ6+wtSFVq9NkZmIu" +
           "6NwZZ3s2vsHqcYap4KKnbLbNx7577om33f/Zv59tm6uV9CoVc/1A4G7kO3r9" +
           "YT+83Irn/Fcp+HAKPpKCX0/Bb34PPOdv3aDvxVcZZj6Vgn+Tgt8GTnMm+jMc" +
           "xPhrBZpTxv49uVtR1edS8Dsp+HQKPpOC33+Zqtp+tQxBRLTFtIx7U519/gZ9" +
           "/+Fl6mzLeC8F/26rvX+fgj9OwRdSkZzA0JL0zbtlRf1ZCv4ko5WCL6bgT1+5" +
           "oo7IewNmX71B31/cspK+koL/lIL/DL74NkqqmeZro6evp+C/HurpL1Pwte/B" +
           "3vsfN+h76VXuvf+egm+m4H+CvRc420suyC3r5X+n4FsZrRT8TQr+9ntlP9+5" +
           "8aH5kW1EodLvfS90wcni2GfEDnTLZvZ3");
        java.lang.String jlc$ClassType$jl5$1 =
          ("KfhuSusU+NyIRCN4TSxs53wKzh5Y2M5tKTj3GlnYztYu6hmzC9cdsJN9ge/c" +
           "fQsn5J30itPOxRRc2k7qlhX0wHEF3ZuC+19LU9vdzqiegk9nbB++marecKsm" +
           "tfNQCh5JwaOvob7eeFxfT6TgyTiA7jx6ozPt1sE56oGr7pRv7kHLv/zChdvv" +
           "f2HyJ1l25/Cu8jkaul0LTfPoRcQjz2ddT9WMbILnNgmd7ON456kAeuymqYoA" +
           "OmMcfN7vvGmD+HQAvf4GiAF0PjiW3DjAg8Gn9Ek8QD/7f3RcHlDYjgMxdvNw" +
           "dEgJHE3AkPSxnF6YvM7Z7tLNFutI2vGJ637QdMPN9f8r8ideaPd+9KXyxzY3" +
           "LsEBc71OqYAvhts2ybSMaJqYeuy61A5onW099e27fuXckweJzLs2Am/3zRHZ" +
           "3nDtNBdpuUGWmFr/5v2/9pZ//sKXs1t//w/wvnNalTEAAA==");
    }
    public static final org.apache.batik.transcoder.TranscodingHints.Key
      KEY_GAMMA =
      new org.apache.batik.transcoder.keys.FloatKey(
      );
    public static final float[] DEFAULT_CHROMA =
      { 0.3127F,
    0.329F,
    0.64F,
    0.33F,
    0.3F,
    0.6F,
    0.15F,
    0.06F };
    public static final org.apache.batik.transcoder.TranscodingHints.Key
      KEY_INDEXED =
      new org.apache.batik.transcoder.keys.IntegerKey(
      );
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public ent.runtime.ENT_Attributable ENT_copy() {
        org.apache.batik.transcoder.image.PNGTranscoder ENT_ld =
          new org.apache.batik.transcoder.image.PNGTranscoder(
          );
        return ENT_ld;
    }
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "y1rPe5VFAPfipdhlMA93196o43mtgBtvWb6RVKXp1PC1pVTeDCkFW8Btq9HH" +
       "xqNKzoclZjWmQxvTtTgpzfXplNgMqtxM4rDJrOU1RGXMYpjXWguG5U27VXud" +
       "VFHH71tbjUCEOYdPEXmgayq/alcpxuwtTDgjyJ4LVMo2M8RUqV59hKBJ5ILg" +
       "QlfzTHFLtXCSVBC4azFLUvNXaJhq+niYUlNm4g4xlzNRot6qE4aoY0QnoY0G" +
       "Enc3UqTT1YnTTTYtUhczIa51ZB5Z9R2zr6CRMChngtKL7bQtYUiH1DuRKKRL" +
       "8DG4Ttu0FXqlMtsjSdZYOzZhCEiAsnInaMUs1q1K9hjzwjY7HWVO0yXHiAWC" +
       "wBeqfWLd4frruqmZ5azMul124GRzkfaw2YJrNyRZrXPzKOG7M2e56Cgb1AmQ" +
       "8WiqTk1mgsNia4a1R6hYE5XOqpWWOsuWGuMelZQ5sxEuEU7mNZKxuOlk2G+U" +
       "WNKvq2ZaU2pSq08hsWBh9KaChNysrm86dVrfTJlKZT1V+kxNSvFR0Niu+tmw" +
       "vF6WWl5rMyNqg1KH0knaT4l2cyA0+M5YtdzEr/jLXkTqvdWAnyGka0xLEz6T" +
       "2vDEVZM2sXLqrpsxDdTr61vTaw/wFcqbusgtJj05GBMjGe0APaeVagcWSh1X" +
       "kTZoKhAG1hLM6max7LJ1jKrB6VqJlInqOpqgoit/k7E0KXTHDBqvtiyNtdZb" +
       "QyPCRi0INAk4BY9tRrpfaxJdFV2bhs9MR3wzTDIpWqi1TbUllY1Mny6lKeE1" +
       "5m4/RumsZFnjrJG15h0xFoyp2XOXkWCThNfrDPvyNuux9mJl0DWsnJATc2B1" +
       "8I6F4ohtVGzNHVmEvBnovSjqyTLc59sJGmxbAyK2bVOtw2pCzrZJvzGPVCWQ" +
       "02YLfHFQlUVzW6omZCu26xsam7eWLhH22isarZNMN4wIRO4MCE2MVxWGUrVw" +
       "ylio1mv31z1i3RUzXRLG7nye8fFkwjWyEkzNiXHaa9qMzCYCrhI0M2J6cgXz" +
       "enEsUtttfZHp1UQXRWFd9kY22l5OESoh6Waz5WXdmMTcoV+r1GbhhAtahNfe" +
       "TKlYSGHNw9Ruad32SbkmG8NFK6sLGwWWQ6XOTgKSXY8FbQBXa5vVPCUaqjrv" +
       "apLXMJnpmkUmwEiUKUstAFsx2SbXiCbX4pjCrO6IjNv9tEUnXTleww3CGbOU" +
       "NVgJpD+osY7HRyULt3EeLL9yb6BUWq0tnDK9GmdNVao0wzbt8mal9/AaPcPV" +
       "9WqoDjAk6aL1bbfRSqpM0qqz3aY+NZPOcMS3a0ZrSISkPok3g80QC4eanjkI" +
       "AVZxH1HYZWOqxZSGmTNgicRYlybRSh2WxlKY2sKcbXL0xpLEqD2e9Rur1lyd" +
       "LqaEEarl2VhP+nC3bCOtgFzVu2sFb62aWcRvtO5qq1uIU2uEXc/31PUWEzDR" +
       "CeIkNviaX02zpBp0fWzM1YYLPDWmHRdLV6aFztb1URK4sMHISicZpqOVJ5Zx" +
       "SUTDictu5m69024zSZeiJVzboqtQ1Jt9pZoEpMkLzYEYYNWqkmLmSN1q3WBg" +
       "behVuxnQjFTm+77oVuEWudGHS0oznVh3esOoVOKsWlNa2oOsXxEHzrSd+Ga7" +
       "4pPuytelthXTG5Ifdech0+pPLIXmdEVV8e2cSsZoo671Jd/mdafa5kpSdaGH" +
       "cr82iDkA1LjjBvRIbw+ma57VFrqRbUo91FNq2yRZ6kNthcv1yqY2Uzf9OukC" +
       "fbVtrYvEo6a9zVoKSa3VVQomc0tslmPSa/kiR5c6pWatzijlQb3H9DhVjRLY" +
       "0LfbWoPpe3qv7Y9QqbleMOl2xrCMYbVBSsLWa2hJ9UpyDWCaRLfkejCPFsYE" +
       "Jipix6VgFobrHRdfrDr1OASrDdyd2xWthNRX20ad9FVdwm1Z6KwVaxi1hFkH" +
       "RzOlbEdzm463HVLxu6Wl2EzDTTDhajRdQztiVYo1kbFI0lU5fzFFh+MuNhnb" +
       "63F/pgRStxl1AzPso2iNDWYztjYepaulqTrT5XqJbNJBi6Wq8+V2OJjyNsM7" +
       "o9BYiOt4xmasO1SNxWjhWepm3CM34YJMiX5ibtWsNJF7ipCYw0pkd+Akq80V" +
       "bjkc6WkwkWgGXbUTvdtdLsy1ppWjhhS21YbTUJxOo9R3FFNfDpAeHrTlpMT4" +
       "HUUdddp8w5faeBiCxKXVcLigjc8Zd+YvK+MFPCW7Q2ZDlt2pNlgBWISF/Ju8" +
       "HbdLGV5Vqhi3pXUPY2R7S3ZEHjWNKZVtKgRTRenuYpSqeH2eTChPnWglqULD" +
       "1TZvjIYtuDSRYCMg2Gk28+A5W4KROK4HcUfVywMJVaJUYbySlGaLBr20OUs1" +
       "2DUv0xw8p7AJxdvkmq7X9NqSgktbhdNUMZSbY0WrD0CKv+yP0qa5xuYLolSB" +
       "cbJKDQy7TWWp3xrwMQo0m/d4YzrZVvmlUebGnjpKejGVraoUWGq9apVgqIZo" +
       "dMJZ5lE1Q/O9dMkGRB+v1Ucre9LzN34UeqqCTaVuadtnOMbXq0oUqJwYtuTF" +
       "SBYRbrVZcsjcWmYRo9jtzjaKhtvIrA56y8mUM8EaM7dq9WQhLBt+o0ZpdlsU" +
       "1GXCO0ytj5sTH3MHgRqrZhgHjfaQE/3YCpedhZZo9XTm0MutbnpYx2Q7/Mzq" +
       "epmVrfqaUV3W6ku3JbeaiNsQ09Zwspwg9aG6BOmfuEJFdAPyyE1luHQWbsxX" +
       "hEXcxQatzrDWpiqxXOMzgOjkOIqUWrhseTMRHizTNTwcSnEIDxVak6dS1sPN" +
       "LayzCwNOEhKvpaMW0vJTqidlwYIWiFW/4fiDutRSWgN11F2uQcZri1xg2mqp" +
       "X2rhlEx67aymRNImLuEVCh7VzUnWE+a9KJDCMKi7PR2erFgEXUzEvjBPVlLX" +
       "dZuVpUwwOpuIOF0f9CatVDb7WG+6dPogOarpTbdLU+pAsBe6Pgybw1baTspE" +
       "xxanvRIHUm5YVra9rr+cNOcLtk10O0hz6lnVSTWoq3qpIzi1gapEYimVtkTH" +
       "b7eassSuVMUnM8zuVLaLdl9mg24w0eQxWlddeVOXJjWf69Tdlte158J6OUXd" +
       "itTbTCudYUN0wTcC79AB7Y23WVMqxejMnzWb7nbJt+gWpzANz7CGw0WtvYCJ" +
       "umzX6EnAb0fqcEKX+EEoIdRiucQCP/Pnw6bs+I3W3DI1tNvw1gHJZWlnHS4X" +
       "Oliim0aJXK/rfVuftsWt5xi9jGuaYg8vp4KAgY+dLo9vmAEuUuCDi7HCoU4N" +
       "MjUiiFGpvUo5ZDMMwpBye8ClMppCbBN8WFWasFNCapXFsCFI9CKZGKsVNYlw" +
       "gVBZGOBYhZDgLF51yvGKoedpe8OU1/qyxrn9pYH0OcsozUog+6cQ8IltxjwX" +
       "aoOENkvdEMer1T5T4tBFvT6qzcnENE26zZR9xKujXVfFpI2qhzXVY72x6uHK" +
       "RlTQGPPBGrkUO03ZNFvkUEo2vQbjS1yFxRAE+cAH8u2Kz9zdNsqjxY7R0SUW" +
       "027lDS/fxU5JemIT8GiXDTo8szi1NX9il+3EAdqFw92pdytutB/EbmQ4yj7I" +
       "DW4iURQYqzja7a8G0JO3u8BS7D9/7mOvvCrTv1LZO9gm/IkIeiDy/L9hK4li" +
       "nzqwy9+dI1mLSxr5WcKFA1kv7I4RPnr+LOjHrq1jMTTWsRcpz+/Oh68ZbnQt" +
       "F1Y8EFZ5/oVrL1778G7r9Nq5YyLR98P9QAwjJTAyJdjH3HzvSnlRdFYv7ZM0" +
       "f5Oie9iNn2SvvfSC76fH83A7A58SOm/9df9Oe6efv0PbF/PiVyPo4VPq5JXy" +
       "sSv82pttmp3kesbSb88rnwFP40Doxtm91xP6nvXgC4UHp2+2z/xP79D25bz4" +
       "rQh6SFOiWagEiKYc3IAD3vfMualaBYasKfunKQsjfOktGCE/1oSug+eDB0b4" +
       "4F+PEfaOD0LkoiiovnoHc3wtL/5FBD0oBQrwbjy/anMUi8W+rbiJDm7gdGM1" +
       "vzEiHxMVhvjtt2qI58HTPTBE924MEUGX/MBIgNy3tMaFY3O9XBD84R0M8Ud5" +
       "8a8j6ArwCz4wIgWRRR8E6KEx3n+XN5Sun2NSGOsbb8FYxQ2bPnj4A2Pxf+1e" +
       "8/VDdd/3g5xtKwEdR34cFVz/7NbWP2R4");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("xxtexwyxVFL8/NCr4PmtvHgjgi5vcmMe+93Zjf3EM07A0zffgo2LheBZ6NxC" +
       "8JkfbCE4u2IVFZLnb3cLwikPKeC+ILDlax+45iqba+fbn9/f33/hxvuuHSwl" +
       "O+qi5a2sD//tjuvDX9yh7S/z4r9E0P2HiuW///6x7f/r3dg+BevMKZXzO0qP" +
       "n7tHvLv7Kn3h1Sv3v/PV2b/Z3R84vJ/6AAndr8a2ffJKyYn3i36gqEYh+gO7" +
       "CyaFwfITtvNgfzaiI+g+49DnLkC7jvdG0Lvu0BH46vGPk/0uRdDVs/0A/+L/" +
       "SbrLgMMxXQRd3L2cJHk4gu4BJPnrI/5hfFXeHJ+K+Dk2dnrhREJ0EAjFHD72" +
       "ZnN41OXk1br8eLu4KX54FB3v7orflL74KjF+8XvNX9ld7ZNsMctyLveT0KXd" +
       "LcOj4+xnbsvtkNfF4Qvff+Q3H3jPYYL3yE7g4xg4IdvTt75Hhzl+VNx8y/7J" +
       "O3/r/b/66p8Wx5D/B3mgu0fCLwAA");
}
