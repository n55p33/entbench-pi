package org.apache.batik.css.engine.value.svg;
public class StrokeWidthManager extends org.apache.batik.css.engine.value.LengthManager {
    public boolean isInheritedProperty() { return true; }
    public boolean isAnimatableProperty() { return true; }
    public boolean isAdditiveProperty() { return true; }
    public int getPropertyType() { return org.apache.batik.util.SVGTypes.
                                            TYPE_LENGTH_OR_INHERIT; }
    public java.lang.String getPropertyName() { return org.apache.batik.util.CSSConstants.
                                                         CSS_STROKE_WIDTH_PROPERTY;
    }
    public org.apache.batik.css.engine.value.Value getDefaultValue() {
        return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                 NUMBER_1;
    }
    public org.apache.batik.css.engine.value.Value createValue(org.w3c.css.sac.LexicalUnit lu,
                                                               org.apache.batik.css.engine.CSSEngine engine)
          throws org.w3c.dom.DOMException {
        if (lu.
              getLexicalUnitType(
                ) ==
              org.w3c.css.sac.LexicalUnit.
                SAC_INHERIT) {
            return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                     INHERIT_VALUE;
        }
        return super.
          createValue(
            lu,
            engine);
    }
    protected int getOrientation() { return BOTH_ORIENTATION;
    }
    public StrokeWidthManager() { super();
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "/gPikDQUAx4AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "qU6aIwNGYadDthriJu8FzQ7SY2QbZAg2tfOsDsavsnBpVYZYTZw2KkYlUsZt" +
       "zZeam17NnE7YSdQhA6HdbCQ9Mp8yWq8mNQSHnFZFQcIzwXH59diSGn3Rj2tx" +
       "3IY7ExKsormCxVrFRdClY/D1ltQW43DsCEHNqM/izMAtmp6muTimjYkue2ml" +
       "H/L9Oj1TCcz0Eo+Z9ls+MqvxhtJhxpO0ZY2RAFhLD+mKW3hBpHFACOug1SVs" +
       "octiO1lKeo5Wr3PbyO5XtahmpJNNFs/qxEzY9KqMi41HY2aeZStms9mQqYRs" +
       "HGdFMPg0bizF5tJYAjntaV3uCppP0enCMaT1Ipe8pLMlQwGliAZOwWJnjSMI" +
       "riSj2HTneUU1F/ZCVodVFux65ApnVGc+GkjOMJgsMyX0dkq1KrtDYDdDCrFH" +
       "y2ic8ybpytVgzlETBF1NGtWxm++cGBum7a6SifaciAbLBFnTtcayV2muJklP" +
       "poBOSMyAqyS7qaQqI21DVjcZoW6JbuDRnCrQueChI3JV75AMMc3GOtMccw7e" +
       "8/N8CVLGekQw9DrK/XV1Sy4pSWbzSUdH0yktmuZIa3sgfWopw1qerFqZJzdr" +
       "PF3vGjTRHcOTZAK2y05D6TaHfSpw4nXM2LxKb2gBGcGZMWyMWlvc4fg+vRIE" +
       "ipmnNVLTK4hEVjMYHTK2CaKptRJqxjiXK23PVyNrx+VEOyRbrYZcEZruyiBX" +
       "ccrPDUxk9IggXD8huPUwCvB5EE6iRLI6yoasIlt1aJFxV8PNrl8jt7uAQwxv" +
       "PJxwZnuyMCinXhfRRt6c0wutNVmLatxPNnNCyEfzCt6T6ivUhDUTp1kcXzU7" +
       "IdHJBnaLSVSS1zuq6XY0Re/3aq2oLSM7nUUpTqtVxJjNxoEZBsISrrEde+Y1" +
       "CRXRg3U6Q9Gl1VaCGPHaIgjvnayNKMN1J+84jZUCst26kAwte74Uw4bkWVhg" +
       "jBySaskpF/MrHmmbpIjpm2mnU2+oPLvktGTMTdMpOd/KXcKa2qtI27U3fAyD" +
       "lyaUX7lsX1ywk/kKzdXWxl6lG490GT702r2ska5If7vT6j2hwWZ1PzbiSpP2" +
       "Bw24qa31Cs7xbJCZjQ1Zq7biTdRYVNSNpOlLflE3McwVrKhptNaTlsrlSr5b" +
       "LNxmh81scT0ymQHPM7vKYMdMjFQZDuh2QvGjICeXeqpuHSwnSZ/J/CZMDvk6" +
       "NRKjqtXzx5IEEhN1Vad7MkhYXBS85oIMfzNma8GkYmqSksyocAnzOzWmSZ7Y" +
       "LntKRBjDFg7e+ZixQfbI9hDWZrrZn7PdtAleRN/5zuIV9Zte3inB/eWByMmd" +
       "lmEhRcfoZbwd77seK4rHTw6By7/LtzgEPnNQBhVv/G++2VVV+bb/yfc997xC" +
       "/1jt4OiAkQ+hu0PX+zpLjVXrzFB3gZGevPnJBlXe1J0efP3m+/7x4eU3bJ95" +
       "GUf7b7kg58Uhf5L69G+N3i7/wAF028kx2HV3iOeZnjp/+HWPr4aR7yzPHYG9" +
       "+USzDxYaezt4njzS7JM3Pl6/oRVcKq1gv/a3OL/1b9FXnkjbIfSgHuDOVvX1" +
       "UFVmvlveypYMizMGw4XQnWvXtVTJOTUm56WOWs5OWTYY59G/Azy1I/S1Vx/9" +
       "e2/R951F8W0h9Do96Dq6LYXFwfsx/KIvPsX57CvFWfgMeoQTffVxft8t+r6/" +
       "KD4QQg/oxRV9efR2E5Tf8wpQXikaHwHPu45QvuvVR/mxW/T9SFE8F0JXNDU8" +
       "hndyr3XBjm/Tj76dKFF/5BWgfqBofAw8wyPUw1cf9U/cou9TRfGj51FPj+LP" +
       "6BTiJ18BxHILeBQ81BFE6tWH+LO36Pv5ovjMHmIf7OORtb+uOD7mf8dL3zef" +
       "0pfa+Owr1cabwLM80sby1dHGQUlwcAzqqwtQSUMusQSSfEiqqS5LFuvo4THN" +
       "47cCjjHMoKyVs/3qhdkuHd2gH4300PFsimsf9mlqkMqqV2yeJfPni+JzIfQa" +
       "2VelUC2VWTT94qlGf/mVulBhX88cafSZl6NRkDx4vhuqMti6XtLM/vgWfX9a" +
       "FL8XQvcBM6N9XXX26UPR+olToL//coCmIOZe/5lDcU/70HWfXO0/E5J/+vkr" +
       "d73xefZPy5v+k0957iahuzaRZZ29VjtTvwzeMTZ6ieLu/SWbV/77wkvYyMnH" +
       "GCAigrKU/y/3rH8dQo+9JGt4dPN1lvFvj2z3JowhdHlfOcvzd2APvhEPEAuU" +
       "Zyn/MYSuXqQEUpT/z9J9KYTuOaUDk+4rZ0m+DEYHJEX1Re/YEeCXVhcJfp2s" +
       "ZXrpfO57YicPvJSdnEmX33YuyS2/2TtOSKP9V3tPy595nph+64vtH9t/SSFb" +
       "Up4Xo9xFQnfuP+o4SWofu+lox2NdHj/xlfs+e/fjxwn4fXuBT73sjGxvufGn" +
       "CgPbC8uPC/JffOPPfv2PP/+F8oLz/wBUQdKFTCkAAA==");
}
