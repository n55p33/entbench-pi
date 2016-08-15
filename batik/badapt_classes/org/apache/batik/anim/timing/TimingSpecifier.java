package org.apache.batik.anim.timing;
public abstract class TimingSpecifier {
    protected org.apache.batik.anim.timing.TimedElement owner;
    protected boolean isBegin;
    protected TimingSpecifier(org.apache.batik.anim.timing.TimedElement owner,
                              boolean isBegin) { super();
                                                 this.owner = owner;
                                                 this.isBegin = isBegin; }
    public org.apache.batik.anim.timing.TimedElement getOwner() { return owner;
    }
    public boolean isBegin() { return isBegin; }
    public void initialize() {  }
    public void deinitialize() {  }
    public abstract boolean isEventCondition();
    float newInterval(org.apache.batik.anim.timing.Interval interval) { return java.lang.Float.
                                                                                 POSITIVE_INFINITY;
    }
    float removeInterval(org.apache.batik.anim.timing.Interval interval) {
        return java.lang.Float.
                 POSITIVE_INFINITY;
    }
    float handleTimebaseUpdate(org.apache.batik.anim.timing.InstanceTime instanceTime,
                               float newTime) { return java.lang.Float.
                                                         POSITIVE_INFINITY;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "jnrIA7YnqT2psGjI/dCUaKEJnULi/4Uf3S+j+Pqpj0yQ14DfL7/Hin9X765e" +
       "vTy4O9jDx/4Pa8sf+4//6zVCKMz4HTTuEv0KfeVzj3c+8AcF/cGe5tRPJa/1" +
       "djAQPtBiP+f8j6P3XvtnR8h9K+SmchJli5Id5VZqBSPL8DT0hpH4hfqLUeI+" +
       "JHrhzF88cVnlzw172ZIfVA3m89Z5/oE7Ge9n4PP0iVF7+rLxvoIUmVFB8kyR" +
       "3sqTP7u3lXn2zxWd1gGMZeMTEZX3Nj9PP5An9H4iW6876b2LLD0Fn2dPWHr2" +
       "dVia/mlYus8K25phFW4Dv8QU/4ZMFZ0kV6BHuIodN44LVMs7D3sPgJ9PkWxb" +
       "0A5fC4svG0ilW65kn/Ly7rWt3Dq1NCL80oHqeGttN04N7c1iJeUTf7z/PLjE" +
       "b/1PzS9cKQ8dOqM9+KXxyf/06a/9rfd9A6rzELm6y1UNavG5EZko//j66698" +
       "5sm3vfTNTxbeEMpS/Mizf1iEstrroM6zH8yTD+XJ7VOoj+dQ+SKspKUQjAvv" +
       "palnaLFzeJoA+kDvLaAFNwBVCwet0x89W0lYrCQLN2p0LbZW1a0hK5i7djKh" +
       "QNLuBFPD60wcwYwja+kIVjdoreZ4Ve6XmqCxCzPguuVeu+VtbNngDZJvUxuh" +
       "xhrkqlMeWRWRT3xyJLa9Id8C65pPLdLtzDNHFXPijQgOOKrT1HFiN5i5VT6L" +
       "qozONKtVVGcIPGmUqHKayL0hmzE1yyNWGemAcdXYgSnmqJE7U2S5vehJuF8L" +
       "Sk3CrzJ2aTnsLgif6g9YP5zVg3a01pxtudycSwO5u5XIeJUx65FDl7EwMQlj" +
       "bTuOW95kMlNXbDnarjx9yPpjQ1hOtPJYkvoKVtlGcc/h+FpHaE9dY9gp13ip" +
       "NKRd1eHpijV3xqXSMG5pPdVo81SG2jV22MRW1QVP+gZQysR4lWl9dbqKQkAm" +
       "hNxrVbWlJ2rzbVUP6oHhYatmE8xCdros1zS92m3M6N4kNpJtP12KtcyWHYfz" +
       "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");
}
