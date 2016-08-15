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
          1471028785000L;
        java.lang.String jlc$ClassType$jl7 =
          ("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");
        java.lang.String jlc$CompilerVersion$jl5 =
          "2.7.0";
        long jlc$SourceLastModified$jl5 =
          1471028785000L;
        java.lang.String jlc$ClassType$jl5 =
          ("H4sIAAAAAAAAAL16abArWXlY3/uWmfdmmPfmjWfJMDPM8oZi0Ph2a2tJGbCR" +
           "Wku31JJa6la31LZ59N4t9b5KsocAKRtsB0xgJsFVePwHKokLG1cqJE6lcMaV" +
           "YIPxEhwqBqcMeKnY4BAzqcJxQgw53br36t77tpl5Q1SlT60+5/vOd77zLed8" +
           "3/nEN6EzgQ/lXMdcaaYT7inLcG9ulvfClasEe12yTAl+oMiYKQQBA95dkR7/" +
           "1Qt/850P6hd3obM8dI9g204ohIZjB2MlcMxYkUnowvZty1SsIIQuknMhFuAo" +
           "NEyYNILwGRK64whqCF0mD1iAAQswYAHOWIDr214A6XWKHVlYiiHYYeBB74R2" +
           "SOisK6XshdBjx4m4gi9Y+2SobAaAwu3pfxZMKkNe+tCjh3PfzPmqCT+fg5/7" +
           "p2+/+C9PQRd46IJh0yk7EmAiBIPw0J2WYomKH9RlWZF56G5bUWRa8Q3BNNYZ" +
           "3zx0KTA0WwgjXzkUUvoychU/G3MruTuldG5+JIWOfzg91VBM+eDfGdUUNDDX" +
           "+7Zz3cywnb4HEzxvAMZ8VZCUA5TTC8OWQ+gNJzEO53i5BzoA1NssJdSdw6FO" +
           "2wJ4AV3arJ0p2BpMh75ha6DrGScCo4TQg9clmsraFaSFoClXQuiBk/2oTRPo" +
           "dS4TRIoSQvee7JZRAqv04IlVOrI+3xy85QM/buP2bsazrEhmyv/tAOmRE0hj" +
           "RVV8xZaUDeKdbyb/iXDfp9+3C0Gg870nOm/6/JufeOltTz/y4mc3fV5/jT5D" +
           "ca5I4RXpY+JdX3gIe6p2KmXjdtcJjHTxj808U39qv+WZpQss775Dimnj3kHj" +
           "i+PfnL3rl5S/2oXOE9BZyTEjC+jR3ZJjuYap+B3FVnwhVGQCOqfYMpa1E9Bt" +
           "4Jk0bGXzdqiqgRIS0Gkze3XWyf4DEamARCqi28CzYavOwbMrhHr2vHQhCLoD" +
           "fKEz4Ps8tPn8dApCSIR1x1JgQRJsw3ZgynfS+QewYocikK0Oi0DrF3DgRD5Q" +
           "QdjxNVgAeqAr+w2hL9iB5MiKDxsW0ACYGnSYw3d7qa65/19GWaZzvZjs7IBl" +
           "eOikEzCB/eCOCfpekZ6LGq2XfuXK53cPjWJfSiH0FjDw3mbgvWzgve3Ae9nA" +
           "e8cGvsz5RqjUZTBFxYd2drLBfyDlZrP+YPUWwA8AD3nnU/SPdd/xvsdPAcVz" +
           "k9Op7JeZYT6Q/TkF8J66vtdupy6DyNykBLT4gf8zNMX3/OnfZjM46nhTgrvX" +
           "sJQT+Dz8iY8+iP3QX2X454CPCgWgU8D8Hzlpr8dMLDXck5IFrndLt/BL1rd3" +
           "Hz/7mV3oNh66KO37dVYwI4VWgG89bwQHzh74/mPtx/3Sxgif2bf/EHroJF9H" +
           "hn3mwImmkz9zdEXBc9o7fT6facddWZ+7vwc+O+D73fSbrkT6YmMNl7B9k3z0" +
           "0CZdd7mzE0JnCnuVPSTFfyxd45MCThl4K+3+wpd+7+vFXWh369gvHAmVQAjP" +
           "HHEmKbELmdu4e6syjK+kwvrjj1Affv6b7/2RTF9AjyeuNeDlFKYcg8gIIsxP" +
           "ftb78le/8rEv7h7q2KkQRNNINA0JPARZoAMzUQ1bMDOBPB5C989N6fLBrFkQ" +
           "+ABjl+dmJRPVvSDUZ6ylq7K3iRaZmQGOLl9HXY9E+CvSB7/4rdex3/r1l67S" +
           "1OOC6QvuM5sVyrhaAvL3n7QiXAh00K/04uBHL5ovfgdQ5AFFCbiLYOgDW1we" +
           "E+N+7zO3/dFv/If73vGFU9BuGzpvOoLcFtJgDFxqqIP4rQOfsHR/+G0bl5jc" +
           "DsDFzDahbP6v37CTmfVdW0GQDgiaP/vnH/ydn3viq4CPLnQmTnUYcHBEWoMo" +
           "3Uf81Ceef/iO5772s9maQNAO+64n/zrzytVsgCcz+KYU5DYrlj4+nYIfTMHe" +
           "wTI9mC4TnblHUgjCviMbYB8hZyt1Q9dB+YYFtC3eD5Lws5e+uvjoX/7yJgCe" +
           "9BMnOivve+5nvrf3ged2j2w7nrgq8h/F2Ww9MqZfd7iUj91olAyj/ReffPbf" +
           "/fNn37vh6tLxINoCe8Rf/i9/9zt7H/na567hs0+bzoFSprCwP2z6U775woYX" +
           "fxQvBUT94EMigjhtTPIqlyvSzMIoJo26uiAaBMkQQ3TIWUheaOWNutcRWy27" +
           "1TF8slCRiwtEVeJYLlUK6Go0xSfWWAzmA77hkcIc7KG4iqCV/BmaZ50oP6l2" +
           "KMbkgAhgbu3oHOfZrKzNfAr42hCOldgaFUc9jC+Ig7iyLtpFnBpSLFyM58uS" +
           "3mDEtmVpQy1a9nlKcEaoXJM8jlGo0LLWIszUOVYp9VduLRwOlmtphk2aXcwj" +
           "ZDtiLVqUPXdi1IImT3S8ArLm2pxfnDRc3DBRshCOhAVvemh9sDAtt9id5Acs" +
           "y3CiNHIJb8X4I8M1x9Y63zZ6CI3idbpPEkaja7UCWoxZKkTGhMv1ZrNVBTTW" +
           "0KggdQCPETefAVG0B1VHk5h5m8UQeWJVuAU57Q0FTp9rZb8xmjODkRsh2BJh" +
           "fKIsDfullrHMuXBEziqTfr5YH635NlLstFVqugjD0TLSq4AfeSFVBl0PGZT7" +
           "It1sYL35mpg3x+2+E3Vmcishu/44H0wwVJAZimeDQUVDyf7QXbbHI6I1E6Sy" +
           "NQuMiY0zQm3aEbVJ35GKzGIpkIHjocWR5K56UbXUrVSW61EViTVvjGpt2lf0" +
           "XM8p1UfNxoyvExTNE0tBtoIqE/WbblvA1wo6Nw3XR3XednNhILPYlBt5BarQ" +
           "5/DWis8Pu37kC5g6YmS/y2BNLPKnDlExqaE/7OFdDW34sRD5CFlnlgjekPRJ" +
           "K1gSq1w335zM6QC125127LjB3Cmo42Ck4WNh4RM6UQknC7rSrPcWDOmR3ZyF" +
           "lZr5JYUnzGSm9SWk012IJmoJnZBhHdEcjd32HGb02sxxE8yf64s6PbbEMsJo" +
           "dqHHlWOzuKr0c2Nb54pTQYkRbdCqu/acHbRHsOZoQlwf+8KkK5gdoo60ZxG9" +
           "XhEVO+cpSGOkNcqmVuNLzWUOlnHSXKtBYVVLyotCPVgJBYN2Ai9adVkRqcaV" +
           "YrlkYL0J54BI5ok22i/PK12FR2emOOl1PKm2WvbNEW+TamFek6QcRaFyFXPJ" +
           "FWliRsdceBhem3jjsDsZcF7oNr083xLnU4Huo3G7QIW1thu01+MB53baBYYe" +
           "GBOZbxnzUY7tUEnRwrQGOWi0yioWoNpiXi2seyKhwS6Sx+g6W6Wb7aqs40s5" +
           "CbCxReoEPegmFcJAUTfS8SCsw1wxKTeWM6spOtN6P8ZLJbERuFg+ScS20ZyN" +
           "7eqM0NBWdUXLbNToduh2nh6XRqRR5AssLBurVmyJuWme7zpoaT02Jt3Q6uSo" +
           "xHRazZzfrOcTp+oP2XaMIzNlTiYanqCNxO8zBGZqpW5jNqzO2GYlIPTYrjt8" +
           "rmN5qwKLyLOS19JCYmFWq/zCmcs6XCDz+qo+HBlYJObQshxP8UrJqJfsuSno" +
           "JE9Vq5hkwouG3kRdZeSVwn6uWoYnsGqPG1qdkcQ2HtLqoGaSbIlqjMt5u636" +
           "+BR4EMlpiKtiJefVZjVlLCpRuUVgS75HtK0lVtAKMhY5HFITizUrydVyVVTR" +
           "Sp2g1Jr0J/bIa7jccMES5UZsDljd6BeY1bhv9rg1q2NJ2cZLkxy2zqulEccu" +
           "R7iuTsWAqTvRqs9hguoHwaorBUqPFCWYGhbVVr5WLtkj34kGSb3ikKVqbajC" +
           "sQ6WrII0W7ll0eCpoDiakpJYkAbAn3dr7f5qhnhiXg1zQ6zrBp1CHbN6i6Y7" +
           "omjW56iG6E9aTlfykkUB8We1eiXC2OpCUFqzXE3vjLzBKJl22aojk960g5Fs" +
           "Ync7PK6hfEMbMKhIVssyEufsflFdr4pwpafP5dU0rk9EdhV1OGc4iVndCnIs" +
           "4khwQXVnlNyslWbDKb8CzsZfYzOfVhyGNFukXJa11iTEPHYyLrIJ33SCKNTU" +
           "2C77Y541jRyDO4saOFz1KpM6b5qBNWp7HWygatM1uqBJfjFLPLaXjLRugvi9" +
           "zqJsMu3KUDeW83yjqCsCyylNokRjJtAQVZNKCjMuSloyMNFWrh0sZlJJ1Yb4" +
           "fGQIES61q3jL1fx+mZsPSoUaOL62SCO/qoclp4RMhWkz9IIuOyu77QZFmDWW" +
           "XBfjALDn6Q3Z73dJ3ok4pl9s4uuCMx9U0KQkVwc2UVjMhpTu6sSUYel1h67Y" +
           "bBDRyzw2rLUKMUnNlxJM1CYNRW+HttcOfJIuN/12btRbF1oLtdvrDlr9oo1W" +
           "HRAWcI8usMmgQMq5TtwckKtRsJRtK6TXrWQpRlKBsR1XRxHNrdKmOSkTnCvr" +
           "47ynd00Pr+ZXg1Kn21ktlGVDA75C7krOwCoA77BAGx17OjJjfxoWc8NKs1my" +
           "qmWlFqp9HclVSypeh+XQpILY0upmae0nYoI4mr1YhHzCVgf9gqk77UllnFNw" +
           "xZ/ASlyciLTDLsrrLj3o9ByJbkQrbyi4KEf1fEmFcQaNFjmVCpz2mkEYhQi5" +
           "sJD0CpwznhK91VoVpmuWW1GjcWlag6fVGtjTyNVlqanV8cbUaeaSPDBIfOip" +
           "raE8byPAUMqhjc7pKk4LGGN2og4+zE0CFfxqYK8GvClSpxdrriaTVrfY7g3L" +
           "eijxC3syLBlFqqi1+sZswjTyIY5YoypFilWwC573chURHpViE+3RtiJzI6a7" +
           "bAvL4rBIjlVHLGGShjArdNqmmGXHKJV8vUULxbqBGlTPIzyYpVs1zclXiWZn" +
           "CTZg03HfqBMEWpfLqOj0SXrN1lVxUmFKsKarXt7k236/3xx5Rs5dm6zRoYpV" +
           "uwLzfRLTxDjfB7s8vNmtk0qby3eSdptZ+0s1YYdI2FY4cjS1/HmtAXZp+U57" +
           "5LG8lM9XGnOsV24GjQnqI3hPwfqIb+EujbSp8twcxXJ1HdeSWcVDWEPg61Gu" +
           "bsftqQzL5NrOq2q3rq/7ywCeN6OF6rtNP1Epv9AYULlxONbxwkhNWg10Oh0v" +
           "loEeE0qluYgXY8/rOgWR4ypSdcitZ/xgmbP8KcossGaYw2yVL2kIx9Z665wl" +
           "FVi2UrLznYK0bJXHLh3wlWkcIKRAKj3Px82ODi/F4igiPHdesXsGv25a824k" +
           "9GZItzsuq02Fg6Wi6i+jxrxWwbyhXh7GdGINY0npNktxa1xqt4Z6bSHZ46Ss" +
           "UED/jGrEVmrjXCg2GqWxR8NDx1yEa1jOq7HKjPO2NGy0FsDuprOCZM6MYYvA" +
           "+24xUgYmMhhRTF6qt8WxxM66Qn6krKOkqUy6krxW+eK8uxLnayl2hkORX8yX" +
           "Tm3s9fMEyqxjtUZxXE+mkLXdg715OR9XnEbkIUy/XeZkVG538alUMblokOuV" +
           "l82gy5dbfIXHudgvOzBQXFxu530uqnBhYODyUmV4Y5KLKVtiYnhuoqEA9giF" +
           "mUdGwDMpA4teFSQ1Ihi8PJ03ba48r9K0SFPRMGIHg1ossXQ8KxKqltPmCAF0" +
           "WYPnw2mlUfX6pArsI7a1RFPGcZ3oUgsd7fiCoyqSh5c6rKIOZcy3YHyiS3CJ" +
           "ToQ+gS/UpEEQNlNFpZGsSEh97fTngrio+Xlr1F2vy6g2lQttEWESrqZiuWWz" +
           "2gzweELTTW9kKpyQk4J5W+11mH4Z1gSMms2VRqVhoHLAELVhYzRGI6kpefl+" +
           "odytjmKC1AhsYCYuFlo2j4qUaRFslDN9EMOTuTKimpw1i9e1JO6rU6wnqSVF" +
           "86taDotbQ4ZqsUBvObm07o/ZCjg4LNZJdYy3xKQ/61Ital1rUrHFl6ZULylE" +
           "IGImVNjuWXJDKY8rDaqcW2FwlUnE6giuS8PIG65WC5SqLUsxP8zPOQWutYL2" +
           "tI6NV4oPtpzIUi3Qc7qJIyDSMIYxs5PyUpIcdbVoGkBZTJuhFxNipTcmUcul" +
           "8mKDrowWPOu5mEZJyiREeGk4qLNW5Db6klIWyIEdrCQeKbJTgUUbeH+0bhYG" +
           "AzOPzOa8rHXqurbgbSrIE64qDWhwDGNgv7BedddLv1BoC1XBnMlFtqwOwcmM" +
           "FeCVMYADNACHLFrvu4xKIbkQzcVVGhFapCl7wSSPrKu9BYfh3ng5CW2t1Mtb" +
           "vh6Z7qyXWHy7DDbKfI+TynJ5wUcRN1rFeSTp1mAFxrGkj7e1Ct+icH28dpRh" +
           "M99MqiPS8b1JVVS5YDVd16uFrknLaFPA5V7c6VA9Oyz6YGNXifR2reQXmVpT" +
           "FGsWNh02q4NFUbKnQyuZtmzeyBWbvRzNSkXc00suV/bK017C1v1YH/ZzzGgu" +
           "1ytdvVRmxKmchOGgMImdBA45FUfoWkhOndY8hzvGaooRHPA0RZTLu/3CZDwW" +
           "gnllbs+qMMzDzTW3iNdMdRZx5UppWY6reQclqjBThSl9XFYatXwFRWdgL6hr" +
           "mIvWu0VE6SPUpNlj1ajXnyIhOxGCOtOVQyamCaybTDguNMq0JePs2rDFdnVZ" +
           "wN2cJOlLk6eoMjgQk/MKPCK8aQNf9ksTqtGaa0xEFyWPLxWBDzNVaRIXxEIu" +
           "wuwx1h0qbqkwya0nFTywlusYTsikDuL3YFhaK/gIQayCYEmDRWGSFmXsCWk3" +
           "EryP5lblFZkfrBY9e7oKhnNtnugcPKopUeKiZaNfr9ff+tY0zUC8skzP3VlC" +
           "7rCWMzcraQPyCjIcy2sPeDobMIRuF8Qg9AUpzMYOoXOHFaYNC0fS0lCavnn4" +
           "erWaLHXzsfc894I8/Hg+Td2kiM0QOrtfQtvSOQ/IvPn6Oap+Vqfa5pF/6z3f" +
           "eJD5If0dWSL1qvw2CZ1PMam0HHhY9nvDCSZPkvwX/U98rvNG6UO70KnDrPJV" +
           "FbTjSM8czyWf95Uw8m3mMKPsQ49fldhyJEWOfGU77psfFT515dPPXt6FTh9N" +
           "tacUHj6RuL5DdXxLMNMBDkp250Pdd5Ltm6NZbCDWdM2hN4Hvh/drOh9KQdp6" +
           "j5vCH1huteYqddg91L/x/rr70Bu3CVTMMU1FyqR+eWJbWb5REE0lLWb83wtP" +
           "5j/13z9wcZONM8Gbg2V4+uYEtu//XgN61+ff/r8eycjsSGkRdJsS3nbbVNbu" +
           "2VKu+76wSvlYvvsPHv753xJ+4RS0Q0CnA2OtZKWuU/sllf0MNvwKizoHeA9l" +
           "IwpJuN+pEalpMUQm0n8HnZ6+EfEtzWEUulGYyVnNUIUMKoDPnYzbnZfF7ZZg" +
           "aykpbiqdjGZWSvixEDqfpPWoLYM/fMRVYCF0OnYMeetD3n6zLKmSvT1SrJpt" +
           "CyjQtQso950s4uxlxXzXfWWqeEMRHUmyb8bIkN55AumA8fT/ezbcp2CVvfgH" +
           "12ZkJ2Nkw0MKnk3Bu1PwD4FbU7xIMINrCfY20XFMRbC3sl3dTLbXZvT9Kfip" +
           "FLw3BT+Tgn90kvlXKcWj43zoBm3PvUxhbcfb20rsH6fgwyl4HkQaTQmzaHFj" +
           "909HICAduQHwfuOF3/3tb19496YacLy2kV0C2Uc9ifflL50q3BFe/rksbJwW" +
           "hSBz1LcDNxukPUPo0etfKMlobQoXd9xUye/dKnk2/KGOH2joha2GZh3S1794" +
           "rBJybSFckQjrCv2pL78XzXzihdgIgD3LzP4dl+MecltcfubYvZdriumK9Jef" +
           "fP9nH/sGe092oWEjkZStIvCu6S+6r6k7mabuZvbmQ09eh+F9jjKHfkX6iY9+" +
           "93e//uxXPncKOgtiVhpchdRP2iG0d717QEcJXGbAUxNggYh71wbbsLVDwYEF" +
           "vHT49jDEhtAPXo92VvU6EYnTmzSmkyh+w4lseT/8Hgvvkesebc1U4c5Xrwrv" +
           "BMHwZQjvcO77ERy6lCn9kWJjWv462uiG0D0YWafpK8yMal1h62Oi3iBbmYq5" +
           "oHGHyWx2eYPV4wxTxgRf3pjNx7937om33f+5v5+ZzdVCepWCuX4gcDf8Hb3+" +
           "sB9ebsVz/tsUfCQFH03Bv07Br30fPOev36DtxVcZZj6dgn+fgt8ATlMXAh0D" +
           "Mf5ageaUsX9P7lZE9fkU/McUfCYFn03Bb79MUW1PLWMQEW0hLePeVGZfuEHb" +
           "f36ZMtsOvJeC399K7z+l4A9S8MWUJSc01FX6z79lQf3XFPxhRisFX0rBH71y" +
           "QR3h9waDfe0GbX96y0L6agr+JAV/Bk58GyHVTfO1kdM3UvDfDuX0Fyn4+vfB" +
           "9v76Bm0vvUrb+x8p+FYK/iewvdDZXnJBblku/zsF385opeBvUvC33y/9+e6N" +
           "N82PbCMKkZ73/cgFO4tjx4gd6JbV7O9S");
        java.lang.String jlc$ClassType$jl5$1 =
          ("8L2U1ilw3EgEI3xNNGznfArOHmjYzm0pOPcaadjOVi8a2WAXrtthJzuB79x9" +
           "CzvknfSK087FFFzaTuqWBfTAcQHdm4L7X0tV293OqJGCz2TDPnwzUb3hVlVq" +
           "56EUPJKCR19Deb3xuLyeSMGTyxC68+iNzrRZA/uoB666U765By39ygsXbr//" +
           "hckfZtmdw7vK50jodjUyzaMXEY88n3V9RTWyCZ7bJHSyw/HOUyH02E1TFSF0" +
           "xjg43u+8aYP4dAi9/gaIIXQ+PJbcOMCDwVH6JB6gn/0e7VcAFLb9QIzdPBzt" +
           "UgZbE9AlfUTTC5PX2dtdutliHUk7PnHdA00/2lz/vyJ98oXu4MdfQj++uXEJ" +
           "NpjrdUoFnBhu2yTTMqJpYuqx61I7oHUWf+o7d/3quScPEpl3bRje2s0R3t5w" +
           "7TRXy3LDLDG1/rX7/9Vb/tkLX8lu/f0/L8RvWZUxAAA=");
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
      1471028785000L;
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
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "rx2I+97v525bCeg48uOooPoXt9b+AcE7");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("vvA6IoilkuLnl14FzW/myRsRdHmTK/PI7k4f7CeecQyevvEWdFwsBM9AZxaC" +
       "T39/C8HpFasokDx/u1sQTlhIAfdFA1u+9v5rrrK5drb++b29vRduvPfa/lKy" +
       "a13UvJX14b/dcX34qzvU/XWe/JcIunQgWP77Hx3p/r/eje5TsM6cEDl/o/TY" +
       "mXfEu7ev0udfvXLpna/O/vXu/cDB+9T7SeiSGtv28Sclx/IX/EBRjYL1+3cP" +
       "TAqF5TdsZ8H+tEdH0H3Ggc2dg3Yd742gd92hI7DVox/H+12MoKun+wH6xf/j" +
       "7S4DCkftIujCLnO8yUMRdA9okmcf9g/8q/Lm+FT4z5Gy03PHAqJ9Ryjm8NE3" +
       "m8PDLsef1uXX28VL8YOr6Hj3Vvym9IVXifGL32380u5pn2SLWZZTuURCF3ev" +
       "DA+vs5++LbUDWheGL3zv4V+//7mDAO/hHcNHPnCMt6du/Y4Oc/yoePmW/fN3" +
       "/sb7fvnVPy+uIf8PYpb3S8IvAAA=");
}
