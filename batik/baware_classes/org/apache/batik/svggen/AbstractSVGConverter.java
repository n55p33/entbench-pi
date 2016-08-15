package org.apache.batik.svggen;
public abstract class AbstractSVGConverter implements org.apache.batik.svggen.SVGConverter, org.apache.batik.svggen.ErrorConstants {
    protected org.apache.batik.svggen.SVGGeneratorContext generatorContext;
    protected java.util.Map descMap = new java.util.HashMap();
    protected java.util.List defSet = new java.util.LinkedList();
    public AbstractSVGConverter(org.apache.batik.svggen.SVGGeneratorContext generatorContext) {
        super(
          );
        if (generatorContext ==
              null)
            throw new org.apache.batik.svggen.SVGGraphics2DRuntimeException(
              ERR_CONTEXT_NULL);
        this.
          generatorContext =
          generatorContext;
    }
    public java.util.List getDefinitionSet() { return defSet; }
    public final java.lang.String doubleString(double value) { return generatorContext.
                                                                 doubleString(
                                                                   value);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "dg4r+0unsPfey5B0btjLgHS2WIBySV2Wr13CoCdKKzfB8+JxeL54GYOuQFUB" +
       "rbq8v3rfLF/fdRLyj0ZxmAIpTeM46v8GfK6A5/+UT8murDis3E9hx9uHF073" +
       "DxFYyW7YlwKi5FM/oF/5bpWvwYF9955+8/JFrUpN6sda1e+h1egeWpVFojIV" +
       "mUIPG2aiA7cG7vf+e7jfVNtV28Hb+m9OvvG1LxZvvnEAqaUG9jtQ7V4nizsP" +
       "N+Wa9aH7rLtne86/Gv69t/78v0jff3QMEY9d1P7J+2l/glHvOAtdoF9ZOb9k" +
       "dPZtGv17wNM5HrZzD6MrfxujXzVMC8RKRSRcHOOp+41xotoT55HssFK8ckk3" +
       "9TvqVsmSXwFO/hByq3ur8kjj7tI/UBa/G8idVGcz0MNyAs07Uedp19Nvnji/" +
       "BM5qAIluul73RNwblbhlzN86HHAuyUr+rWUFXvrEGTM2BGelH/uTz/7hj3/w" +
       "68AlGeihbYkywMvOjchl5fHxR9743Psee+0bP1at52A6pB/69rMfK7mG99O4" +
       "fFVbdudE1WdLVcVqY8xqSTqulmDTqLS9L4ALseODncr2+GwEv/rU19df+LNf" +
       "PJx7LqP1JWLz06/96N/c+sxrR+dOmx+848B3vs/hxFkJ/Y5jC5+P77uMUvUg" +
       "//TNV3/r51/91EGqpy6enYgg83/x3/7vP7z1+W/8/l027A964f/DxKbXX6Za" +
       "CY2efFhJteTdPM9li0c4d9iEi+GsNfZRnrBnKY069bw+WLk7foLaPVJ0w767" +
       "xY2A7XeXi8Uy6I7H0VKh5xMpk+brkI6VASwmESUqzmZqN7kp4k17neHam69C" +
       "bbAhQ0wVRYmfh9gqkoyNv0RUZFnAGdohEC9QekEQbIvlrtmFm6YPU+qw4845" +
       "EnXnsq900xEzlNsLTdSRGcOE8+4gWoZingnTFma16wgsN5zWKGRpdVOLsfY0" +
       "oX1ZJGaMTA3r2FTlRE9m5FHGiLMBj4ecsmJclOTUOcKF6TBHImpKer7Yma6T" +
       "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");
}
