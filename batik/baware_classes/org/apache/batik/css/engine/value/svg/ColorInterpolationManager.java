package org.apache.batik.css.engine.value.svg;
public class ColorInterpolationManager extends org.apache.batik.css.engine.value.IdentifierManager {
    protected static final org.apache.batik.css.engine.value.StringMap values =
      new org.apache.batik.css.engine.value.StringMap(
      );
    static { values.put(org.apache.batik.util.CSSConstants.CSS_AUTO_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          AUTO_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_LINEARRGB_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          LINEARRGB_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_SRGB_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          SRGB_VALUE); }
    public boolean isInheritedProperty() { return true; }
    public boolean isAnimatableProperty() { return true; }
    public boolean isAdditiveProperty() { return false; }
    public int getPropertyType() { return org.apache.batik.util.SVGTypes.
                                            TYPE_IDENT; }
    public java.lang.String getPropertyName() { return org.apache.batik.util.CSSConstants.
                                                         CSS_COLOR_INTERPOLATION_PROPERTY;
    }
    public org.apache.batik.css.engine.value.Value getDefaultValue() {
        return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                 SRGB_VALUE;
    }
    public org.apache.batik.css.engine.value.StringMap getIdentifiers() {
        return values;
    }
    public ColorInterpolationManager() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "256PX7rnnXNSItt3nh6Pxp9DHjd77BqYsB7H5sGzybbDprGbsBBrETOdKjL2" +
       "LDbf95twA8QqpxqrEwU+1qR21eVa6MQ1sNBEHJsLT9xWMz52CxViLWKFnxUZ" +
       "ewmbn1gWWs1SNKNYBbtjoUWj16suvTDc89fAcA04Nh8eamtPx264QqxFjPNG" +
       "kbFfY3OGkxowXEcSsiUc+JlVV3a7xvjl/8IYWU6mF7z6w3PqtLz/Jqz7dOmZ" +
       "I7UVU4/ceU5Uy7k772qoflIZRfGepDzvZbrBUrJQsto6V+ni6x1OFnyue0oI" +
       "QdAKbc5ZrO9xMm9UVjheDeSgZDOe52RmEUY4XlkvXp4/QFodiQfEgtZL+SFE" +
       "gCAlSCG+vXQfcVLl0sGi1ouX5GOYHUjw9aLuOM+No5vLhY69n9mQ/wyWg1LD" +
       "aFDyHNvm+2pV8QeXU8xlrL+4eqSTR9ZvuOfyF5607vQkhQ4P4yzjoYSzbg5z" +
       "p5Z5BWdz5ipbt/hKzanKBU5t6btT9MomAA35SNy/zQhccpnNubuud4+2vvir" +
       "vWVvQVW8lYQonA625t8fZPUMHBe3xvJLVTjhidu3lsWPDa1clvrre+KGhuTd" +
       "ywTpe6Szx+5++8C0o41hMr6DjIOymWXFxcbqIXUTkwaMOJkgm2uyICLuG1V8" +
       "dXANehjFPCLsYptzQq4XL3s5acqv7vOvyKsUbZAZq7SMmsRpoJIe7/Y4p1ff" +
       "wS+j6wEGt8dzoMlaxQLuBkC2J9ap685NaWmNLiLO0MjVA7afiVdsrv4X7KKa" +
       "sfweAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "h3mP4/xqJyy4k24LIbt8rbSe9xi355eNoN80agNEwMswKs0HyyBsTzo9c96n" +
       "wqkmwq4GojHSjY1JZzTHQMSRJsJUlZftSRNjSV7b9Pvzct8qSMkc0WUSjzb2" +
       "bCYVODmFU5aZo/OgQS/AAjPdjDEQOtQaK3IsIfR8FTI4EZEMcLqY13SYDT+G" +
       "Z0ElWDUjqy75VBrN5hrf6VlRcRBrKZsmRDoZKcwQRetjiS9g7MoaC5ZXbczn" +
       "La1dwhO0GSYYVwbfjg2yIo5HCLlCiUAxTHRVldf9Um3WmnIEKTni2sP7w2rX" +
       "6aMh2fFIMDQyRShCF0NN2FPhDVmsLmqrBS7RLR5rlDFMcMbqUIqbITmowEw6" +
       "jjpqu+8t2n4nnovEnIhUwbSwRFGRcO6GRFzHokp3UvecqOs5cTKfkNXqWOXF" +
       "It8p1UU5ULEAXjrDuN+stQPJ8GpRhUWLJopP9YTXaSXCAlfWlX4cjxZem+Jm" +
       "Scca621r1qG0+sbheq4QFa05LAN52XG3jER63B4vPRKjZrgqzo1KWqeqMVYR" +
       "NNNBkMDtLiShOGnXx4aTcCKvCiU20khFtpNlPWyJPkGElDhRmQaDUA1R1SYd" +
       "IjWjtSYXScJ1tZZuWM1IEipTeylg0wIIRfy06VMo12umIcpshN5QhKU1ZmuG" +
       "XOYZpIoO5ljouvMeR8dx2dXRQerXG21TxjAiWEQE1q5Grc1aFBs+6D/K+h/3" +
       "5a7JIAzov16NV3htGPhpEFKrSaEUjJCSMhVQdliKegTV7kTMuJ7O2E0VIdOp" +
       "wcy6TTed8MrKEV0wHWdRiet1ewtCjE1vMjNLaJQsxw2pVldxCS9WenpNEZx4" +
       "kCJoZRikTXPQa1liU12U+y0r9VZzECBExkQqdOzptCxg6dK04Rq9mE1Qp4lt" +
       "0FV5EMQMiG2DDSb3HZ7GJtNJBZaUSXWyxiwMQwJPtWl+pLYUv7FZ8mJITMLO" +
       "MIo9dFpwDTQt9ZvuOlGKHj2U8a4oVfmwX09Zpz6ZmrrSUDiNb/SVKjJyqMmi" +
       "Mret5dyvwMMm+DAdqpQW80yBa1Iaidsc2Sos50NVmjJ2MWoZJS+ZV1v9RXti" +
       "ruoCk/TZQs+rLhl9gdbdujOEV+uZVmIaQrOxbveWTgHxp7WhMp/UUjtkChUl" +
       "4MajOr9M+uq6WUWL2HJo6cPKoLLemN6C24hadeNX+SoxkzdVwxdjWO9uBLdL" +
       "TKoxKsbjOus5OF6ucr01vBnqkuS7vURMEhDfIsulES5n0+VwOqvZi6Hn4ihS" +
       "jWsqP5iwbUIpp8sOMx2buiEnZTuaDRpCSbKXYagUui09Gcvr1dhXUG6TFqqF" +
       "Qo0sepWSzoZow6T7a2c2b6aSGNDzydhaCSyIVjUHSdY0ySSt0rQmz/GeopvN" +
       "AclECz/eDIPKnClHVUEKltiyv1x3o4nI43yAcawTjXyvQysYvKj4JVVdcQXg" +
       "RahWXJM3HmsL6ZBJCItEOnXBR2vVnjBzeozB9IusOcUxQTWmchQuK3Os2xUi" +
       "daWAL9/XZ5/E6gvblbgh34DZPyw0bSyrGL6Ar/Ft1d1Zct/+Zlf+O3WFjfRD" +
       "m41QtsNw++XOAPPdhU+884kn5f4nSyd3N2mFGLo29vxftpWlYh9q6jRo6bWX" +
       "30lh8yPQg83Dr7zzX28bv0F/9AUcj9x5TM7jTf4B+9TXWq+R3n8Sump/K/E5" +
       "h7NHmR48uoF4NlTiJHTHR7YRb9/X7I2Zxl4DnuquZquXPqK4pBWcyK1gO/ZX" +
       "2AN/6xXq3pYlqxi60YhoV1dCI1bkQejlx905w5sOGcyjMXRa9DxbEdwDY0qf" +
       "b2vncJd5QXwUfbZx+tAu+odeevTvuULdb2XJu2LoFUaEu4YjxNnhxR78rO7t" +
       "Bzgff7E47wMPuYuTfOlxfvgKdR/NkvfH0AUju/uQb/VdBuUHXgTKc1nhHeDp" +
       "7KLsvPQof/cKdZ/Mkidj6JymxHvw9s8Gj9nxVcbupZQc9e+8CNQXssK7wTPa" +
       "RT166VF//gp1X8iSTx9F3dv1P8MDiJ95ERDzJeAu8PC7EPmXHuKXr1D3dJb8" +
       "8RZiQ1GFxN4e+ewdK9z//MciB/S5Nv7kRWjjpqzwXvAIu9oQXnptfOMKdd/M" +
       "kq/E0PVAG7SsgA8t1VC2V5DaBwi/+kIQpjH0ystebMhOZm99zs2r7W0h6TNP" +
       "njtzy5OTv83P9vdv9FzLQGfUxLYPH6Qdyp/yQ0U1cjDXbo/V/Pzvr2Povl/o" +
       "FgaYvyDNYXx7y/qdGLr7eVnj3XOhw4z/EEOvugJjDJ3aZg7zfBesGJfiAWKB" +
       "9DDlP8XQ+eOUQIr8/zDdD2Lo7AEd6HSbOUzyQ9A6IMmyP/L3LL/8/Oo6MJHd" +
       "8UxPHI3W9k3mwvOZzKEA794jYVl+fW8vhEq2F/gekT77ZKf3lmfQT27vT0i2" +
       "sNlkrZxhoNPbqxz7Ydjdl21tr61T7Qeevf5z1963FzJevxX4YKYdku3OS19Q" +
       "oBw/zq8UbP7oli889HtPfjc/Avw/SsuWJFcpAAA=");
}
