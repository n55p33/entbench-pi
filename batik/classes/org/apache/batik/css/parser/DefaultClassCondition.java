package org.apache.batik.css.parser;
public class DefaultClassCondition extends org.apache.batik.css.parser.DefaultAttributeCondition {
    public DefaultClassCondition(java.lang.String namespaceURI, java.lang.String value) {
        super(
          "class",
          namespaceURI,
          true,
          value);
    }
    public short getConditionType() { return SAC_CLASS_CONDITION;
    }
    public java.lang.String toString() { return "." + getValue();
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAL1YfWwcRxWfO39/xR+JndRJHNtxguyEuxqaSsFpaeLYjcPZ" +
                                                              "MXZqgUNymdubu9t4b3ezO2uf3RrSIohbiSgKbhsQ8V+uWlDbVIgKELQyqkRb" +
                                                              "tSC1RJSCmiKBRPiIaIRU/ghQ3szs1+2dHYIQJ93c3syb9+Z9/d6bffY6KjMN" +
                                                              "1EZUGqGzOjEjAyodxYZJkv0KNs2jMBeXnizBfztxbWRvGJVPonUZbA5L2CSD" +
                                                              "MlGS5iTaKqsmxapEzBFCkmzHqEFMYkxjKmvqJGqWzaGsrsiSTIe1JGEEE9iI" +
                                                              "oUZMqSEnLEqGbAYUbY3BSaL8JNH9weW+GKqVNH3WI9/kI+/3rTDKrCfLpKgh" +
                                                              "dgpP46hFZSUak03alzPQLl1TZtOKRiMkRyOnlD22CQ7H9hSYoPOF+g9vns80" +
                                                              "cBOsx6qqUa6eOUZMTZkmyRiq92YHFJI1T6MvopIYqvERU9QVc4RGQWgUhDra" +
                                                              "elRw+jqiWtl+jatDHU7lusQORFFHPhMdGzhrsxnlZwYOldTWnW8GbdtdbYWW" +
                                                              "BSo+viu6+OSJhu+WoPpJVC+r4+w4EhyCgpBJMCjJJohh7k8mSXISNarg7HFi" +
                                                              "yFiR52xPN5lyWsXUAvc7ZmGTlk4MLtOzFfgRdDMsiWqGq16KB5T9ryyl4DTo" +
                                                              "2uLpKjQcZPOgYLUMBzNSGOLO3lI6JatJirYFd7g6dn0GCGBrRZbQjOaKKlUx" +
                                                              "TKAmESIKVtPRcQg9NQ2kZRoEoEFR66pMma11LE3hNImziAzQjYoloKrihmBb" +
                                                              "KGoOknFO4KXWgJd8/rk+su/cg+ohNYxCcOYkkRR2/hrY1BbYNEZSxCCQB2Jj" +
                                                              "bU/sCdzy0kIYISBuDhALmu8/dOO+3W0rrwmazUVojiROEYnGpeXEure29Hfv" +
                                                              "LWHHqNQ1U2bOz9OcZ9movdKX0wFhWlyObDHiLK6M/fTzZ75D/hxG1UOoXNIU" +
                                                              "Kwtx1ChpWV1WiHE/UYmBKUkOoSqiJvv5+hCqgOeYrBIxeySVMgkdQqUKnyrX" +
                                                              "+H8wUQpYMBNVw7OspjTnWcc0w59zOkKoAr6oFr5bkPjwX4qS0YyWJVEsYVVW" +
                                                              "teiooTH9zSggTgJsm4kmIOqnoqZmGRCCUc1IRzHEQYbYC5JpsswEIIweJCls" +
                                                              "KZT7EvIpyVWPsGjT/09yckzf9TOhELhiSxAIFMihQ5qSJEZcWrQODNx4Pv6G" +
                                                              "CDKWGLalKOoF0REhOsJFR0B0RIiOFBWNQiEucQM7gnA8uG0KAAAQuLZ7/Pjh" +
                                                              "kwudJRBx+kwp2JyRduZVon4PJRxoj0uXm+rmOq72vhJGpTHUhCVqYYUVlv1G" +
                                                              "GiBLmrKzujYBNcorFe2+UsFqnKFJJAlItVrJsLlUatPEYPMUbfBxcAoZS9no" +
                                                              "6mWk6PnRysWZhye+dGcYhfOrAxNZBsDGto8yTHexuyuICsX41p+99uHlJ+Y1" +
                                                              "Dx/yyo1TJQt2Mh06gzERNE9c6mnHL8Zfmu/iZq8C/KYY8g2gsS0oIw9++hwo" +
                                                              "Z7pUgsIpzchihS05Nq6mGUOb8WZ4sDby5w0QFjUsH9vh22EnKP9lqy06GzeK" +
                                                              "4GZxFtCCl4p7xvVLv/r5Hz/Jze1UlXpfOzBOaJ8PyRizJo5ZjV7YHjUIAbr3" +
                                                              "Lo5+/fHrZ4/xmAWK7cUEdrGxHxAMXAhm/sprp999/+rylbAX5xRKuZWAjijn" +
                                                              "KsnmUfUaSoK0nd55AAkVQAkWNV0PqBCfckrGCYWwxPpH/Y7eF/9yrkHEgQIz" +
                                                              "ThjtvjUDb/6OA+jMGyf+3sbZhCRWiT2beWQC3td7nPcbBp5l58g9/PbWb7yK" +
                                                              "L0GhAHA25TnC8TbMbRDmmm+CxozvZEU3Iooum7+bu3QPp7mTj3cxc/CdiK/t" +
                                                              "ZcMO058a+dnn66fi0vkrH9RNfPDyDa5LfkPmj4RhrPeJ4GPDzhyw3xiErkPY" +
                                                              "zADdXSsjX2hQVm4Cx0ngKAE0m0cMgNBcXtzY1GUVv/7JKy0n3ypB4UFUrWg4" +
                                                              "OYh5CqIqiH1iZgB9c/qn7xOun6mEoYGrigqUL5hg5t9W3LEDWZ1yV8z9YOP3" +
                                                              "9j29dJXHoC54bPYz/BgbdrnRyD/lwZroj8Y8Dgbaulrbwluu5UcWl5JHnuoV" +
                                                              "zUVTfiswAJ3uc7/855uRi799vUjVqaKa/nGFTBPFJzPMROZVimHe0Xlo9d66" +
                                                              "C7/7YVf6wO0UCTbXdosywP5vAyV6Vgf94FFefeRPrUfvzZy8DbzfFjBnkOW3" +
                                                              "h599/f6d0oUwb18F1Be0vfmb+vyGBaEGgT5dZWqymToe9tvdAGh0IKjHDoCe" +
                                                              "4phbJHZcJFtt6xpZPbHG2ufY8FkAjDShbofBi0Ze18CcPG4lTKjwchZopu0m" +
                                                              "+BOjJ6WFrtHfixi8o8gGQdf8TPRrE++cepN7q5KFh2sjX2hAGPlqVYNQ/iP4" +
                                                              "hOD7L/Zl52YTopls6rc72na3pWV5aKDuNe6g+QpE55ven/rWteeEAsGWP0BM" +
                                                              "FhYf+yhyblEklLgXbS+4mvj3iLuRUIcNx9npOtaSwncM/uHy/I+emT8btr00" +
                                                              "RFEZwJlBXR+G3N5uQ77RxUkPPlr/4/NNJYOQqEOo0lLl0xYZSuYHa4VpJXxe" +
                                                              "8C5SXujaZ2YWpyjU44Dcp9gwJp7v+S/xlU3063x+2I3yJrbWCt9eO8p7bz9B" +
                                                              "Vtu6RhKYa6xZbICLWCXVfJXUM4P2vzBDDu6uRXt9VoY2FbxiENdi6fml+sqN" +
                                                              "Sw+8w9HYvbrWQoKlLEXxedrv9XLdICmZq1YrqrLOf+Yp2rzGVYQ1V/yBq/CQ" +
                                                              "2HMG2vdieygqgdFP+WVAmCAlxDT/9dN9laJqjw6Eigc/yaPAHUjY42O60+/s" +
                                                              "+Q9uUe6bL9e6uVBhzeZObb6VU31Fense1vC3Rk46WuK9EVyulg6PPHjj7qdE" +
                                                              "tywpeG6OcamBJBSNu1ujOlbl5vAqP9R9c90LVTscbGgUB/YSY7MvevsBI3QW" +
                                                              "RK2BVtLscjvKd5f3vfyzhfK3AdWOoRCmaP0x3zsb8YIC+lELmoNjsUKwgXrO" +
                                                              "e9y+7m/O3rs79dff8HbIBqctq9PHpStPH//FhU3L0AvXDKEygD2Sm0TVsnlw" +
                                                              "Vh0j0rQxiepkcyAHRwQuMlbykGwdi3fMEpLbxTZnnTvL7loUdRaic+ENFVrH" +
                                                              "GWIc0Cw1aWNhjTeT9zrLKfOWrgc2eDO+CpYW8CmKVUk8NqzrTvGq6NB57meC" +
                                                              "iM4n+e5L/JENS/8G79rX0FEWAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "UX4HsPmDN/zeW3/rxW/mh4n/AwXqAtvSIAAA");
}
