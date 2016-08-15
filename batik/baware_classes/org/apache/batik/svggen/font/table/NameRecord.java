package org.apache.batik.svggen.font.table;
public class NameRecord {
    private short platformId;
    private short encodingId;
    private short languageId;
    private short nameId;
    private short stringLength;
    private short stringOffset;
    private java.lang.String record;
    protected NameRecord(java.io.RandomAccessFile raf) throws java.io.IOException {
        super(
          );
        platformId =
          raf.
            readShort(
              );
        encodingId =
          raf.
            readShort(
              );
        languageId =
          raf.
            readShort(
              );
        nameId =
          raf.
            readShort(
              );
        stringLength =
          raf.
            readShort(
              );
        stringOffset =
          raf.
            readShort(
              );
    }
    public short getEncodingId() { return encodingId; }
    public short getLanguageId() { return languageId; }
    public short getNameId() { return nameId; }
    public short getPlatformId() { return platformId; }
    public java.lang.String getRecordString() { return record; }
    protected void loadString(java.io.RandomAccessFile raf, int stringStorageOffset)
          throws java.io.IOException { java.lang.StringBuffer sb =
                                         new java.lang.StringBuffer(
                                         );
                                       raf.seek(stringStorageOffset +
                                                  stringOffset);
                                       if (platformId == org.apache.batik.svggen.font.table.Table.
                                                           platformAppleUnicode) {
                                           for (int i =
                                                  0;
                                                i <
                                                  stringLength /
                                                  2;
                                                i++) {
                                               sb.
                                                 append(
                                                   raf.
                                                     readChar(
                                                       ));
                                           }
                                       }
                                       else
                                           if (platformId ==
                                                 org.apache.batik.svggen.font.table.Table.
                                                   platformMacintosh) {
                                               for (int i =
                                                      0;
                                                    i <
                                                      stringLength;
                                                    i++) {
                                                   sb.
                                                     append(
                                                       (char)
                                                         raf.
                                                         readByte(
                                                           ));
                                               }
                                           }
                                           else
                                               if (platformId ==
                                                     org.apache.batik.svggen.font.table.Table.
                                                       platformISO) {
                                                   for (int i =
                                                          0;
                                                        i <
                                                          stringLength;
                                                        i++) {
                                                       sb.
                                                         append(
                                                           (char)
                                                             raf.
                                                             readByte(
                                                               ));
                                                   }
                                               }
                                               else
                                                   if (platformId ==
                                                         org.apache.batik.svggen.font.table.Table.
                                                           platformMicrosoft) {
                                                       char c;
                                                       for (int i =
                                                              0;
                                                            i <
                                                              stringLength /
                                                              2;
                                                            i++) {
                                                           c =
                                                             raf.
                                                               readChar(
                                                                 );
                                                           sb.
                                                             append(
                                                               c);
                                                       }
                                                   }
                                       record =
                                         sb.
                                           toString(
                                             );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1ZDYxU1RW+M/vLssv+8Cssu7AsGH6cUREJXQrCuitrZ5cN" +
       "ixiXwvLmzZ3ZB2/ee7x3Z3dAadW2gdrUWos/bZS0CQRrBIzR9MdqMaYVIzVR" +
       "sdYasbVNa2tJJU3VlFZ7zr3vzfuZeUPWlE7y7ry595xzzzn33O+ce+exc6TK" +
       "Mkkb1ViM7TGoFevR2KBkWjTVrUqWtRn6RuQHKqR/bH9vYFWUVA+TKaOS1S9L" +
       "Fu1VqJqyhslcRbOYpMnUGqA0hRyDJrWoOSYxRdeGyXTF6ssaqiIrrF9PUSTY" +
       "IpkJ0iwxZirJHKN9tgBG5iZAkzjXJL4uONyVIPWybuxxyWd5yLs9I0iZdeey" +
       "GGlK7JTGpHiOKWo8oVisK2+SpYau7smoOovRPIvtVFfYLrgxsaLIBR2PN354" +
       "4Z7RJu6CqZKm6YybZ22ilq6O0VSCNLq9PSrNWrvJl0hFgkz2EDPSmXAmjcOk" +
       "cZjUsdalAu0bqJbLduvcHOZIqjZkVIiR+X4hhmRKWVvMINcZJNQy23bODNbO" +
       "K1grrCwy8b6l8YMPbG96ooI0DpNGRRtCdWRQgsEkw+BQmk1S01qXStHUMGnW" +
       "YLGHqKlIqrLXXukWS8loEsvB8jtuwc6cQU0+p+srWEewzczJTDcL5qV5QNm/" +
       "qtKqlAFbZ7i2Cgt7sR8MrFNAMTMtQdzZLJW7FC3FSHuQo2Bj5xeAAFhrspSN" +
       "6oWpKjUJOkiLCBFV0jLxIQg9LQOkVToEoMnI7FCh6GtDkndJGTqCERmgGxRD" +
       "QDWJOwJZGJkeJOOSYJVmB1bJsz7nBlbffau2QYuSCOicorKK+k8GprYA0yaa" +
       "piaFfSAY65ck7pdmPHMgSggQTw8QC5of3Xb+umVtJ08JmjklaDYmd1KZjciH" +
       "k1Neae1evKoC1ag1dEvBxfdZznfZoD3SlTcAYWYUJOJgzBk8uemXt9z+KH0/" +
       "Sur6SLWsq7ksxFGzrGcNRaXmDVSjpsRoqo9Molqqm4/3kRp4TygaFb0b02mL" +
       "sj5SqfKuap3/BhelQQS6qA7eFS2tO++GxEb5e94ghNTAQ+rhaSXiw78Z2REf" +
       "1bM0LsmSpmh6fNDU0X4rDoiTBN+OxpMQ9bvilp4zIQTjupmJSxAHo9QZGMtk" +
       "qBZP64hQUlKl8QEIs01U1s1UDCPN+D/MkUc7p45HIrAErUEAUGHvbNDVFDVH" +
       "5IO59T3nj4+8JIILN4TtIUaugGljYtoYnzYmpo3htDE+bcydlkQifLZpOL1Y" +
       "bFiqXbDpAXXrFw9tu3HHgY4KiDJjvBL8jKQdvuzT7SKDA+cj8omWhr3zz171" +
       "fJRUJkiLJLOcpGIyWWdmAKbkXfZOrk9CXnLTwzxPesC8ZuoyTQE6haUJW0qt" +
       "PkZN7GdkmkeCk7xwm8bDU0dJ/cnJB8fv2PLlK6Mk6s8IOGUVgBmyDyKOF/C6" +
       "M4gEpeQ27n/vwxP379NdTPClGCczFnGiDR3BeAi6Z0ReMk96auSZfZ3c7ZMA" +
       "s5kEewzgsC04hw9yuhz4RltqweC0bmYlFYccH9exUVMfd3t4oDbz92kQFlNw" +
       "D86CZ5G9Kfk3js4wsJ0pAhvjLGAFTw+fHzIe/s3Lf1nO3e1kkkZPCTBEWZcH" +
       "vVBYC8epZjdsN5uUAt3bDw5+575z+7fymAWKBaUm7MS2G1ALlhDc/LVTu998" +
       "5+zhM1E3zhmZZJg6g+1NU/mCnThEGsrYCRMuclUCAFRBAgZO500ahKiSVnD/" +
       "4d76d+PCq576291NIhRU6HEiadnFBbj9l60nt7+0/aM2LiYiYwJ23eaSCVSf" +
       "6kpeZ5rSHtQjf8erc7/7gvQw5AfAZEvZSznMRuztjkrNgmzBORU9tknSUnp2" +
       "nQz4ZvUCYPOFXcHJruTtNcXMUx3mvo09eZkaqBDnW4XNQsu7efz701Nljcj3" +
       "nPmgYcsHz57npvrLNG+s9EtGlwhPbBblQfzMILhtkKxRoLvm5MAXm9STF0Di" +
       "MEjkRm00AWDzvsiyqatqfvvc8zN2vFJBor2kTtWlVK/ENymZBLuDWqOAzXlj" +
       "7XUiMsZroWnCtzwpOIZwx5B8UQeuTnvpde/JGoyv1N4fz3xy9dFDZ3mUGkLG" +
       "HM5fg+nCh8q82HeB4dHXVr5+9Nv3j4tyYXE4Ggb4Zv1ro5q8892Pi1zOcbBE" +
       "KRPgH44/9tDs7jXvc34XkJC7M1+c4gDUXd6rH83+M9pR/YsoqRkmTbJdXG+R" +
       "1Bxu82EoKC2n4oYC3DfuLw5FJdRVANzWIBh6pg1CoZta4R2p8b0hgH5YjZC5" +
       "8LTZqNAWRL8I4S/9nOVy3i7B5goHbGoMU4EDGA1AzeQyQhmpM1SJIVb3pfxp" +
       "GVPfUC5pQQpVsoCYY3ZlefXgDvlA5+AfRRhcVoJB0E1/JP7NLW/sPM3xuBaT" +
       "9GbHdE8KhmTuSQZNQvNP4ROB5xN8UGPsEBVaS7ddJs4r1IkYxmXjMWBAfF/L" +
       "O7seeu+YMCAYfAFieuDgXZ/G7j4oEFYcNhYU1fteHnHgEOZgczNqN7/cLJyj" +
       "988n9j39yL79QqsWf+ncAyfDY7/+z+nYg797sUS1VgWwYbIi5IRE6V8dYdL1" +
       "X2/82T0tFb2Q4PtIbU5TdudoX8ofpjVWLulZLvcY44aubRwuDSORJbAKIj1j" +
       "uxqbARGHa0PB7Ibi4G+347Q9JPhFsFyOzWBxlIdxQ5RDmQKJT8v0pbBnS0DV" +
       "0c+g6jx7snkhqmplVQ3jBlURb3JwfCytqj5BVS+DZ7492fwQVXNlVQ3jZqQa" +
       "I6a0mmMTVBOXrMOeqCNEzdvKqhnGzUi9xU/2UNZnxCEwqOy+z6DsAnu6BSHK" +
       "fqWssmHcBWXFAbeUsl+doLKz4em0p+sMUfaussqGcUMAmPz859RoTbz4wPiN" +
       "icuUgOrfKKN6PjStVRu5pKrIblbjn2oSOL17FPNUNQTRd27YBQtH3sN3HjyU" +
       "2njkKkReZNwOZTvTjStUOkZVj6hqlOQrkPr5lZJbbbw95d4//KQzs34iJ1bs" +
       "a7vImRR/t0NWWBKe44KqvHDnX2dvXjO6YwKHz/aAl4Iif9j/2Is3LJLvjfL7" +
       "M1EGFd27+Zm6/FmlzqQsZ2r+PLKgsK7NuF5YocTtdY0Hw9WNJx6rB/2xWleG" +
       "NXC4cEpm/H2kzNhRbL7PSEOGsh5/CnHD+gcX25Hlq3bs6DF4/0PFvlhuG7R8" +
       "4r4IYy1j7xNlxp7E5pjwRcKfo1xfHL9UvkAYW2kbtHLivghjLWPvz8uMPYfN" +
       "TwEowBcDbhJ0/fD0pYyJLtuYron7IYy1jK2ny4y9jM0LIiYGCweJgC9OXQJf" +
       "tOAYViRrbYPWTtwXYaxl7H2zzNhb2JxhpBF8Ie5F3ST4Ldcbr18Cb/CrswQ8" +
       "3bZJ3RfxxtLi26gw1oDFUa5IFH9eyzs3Y3Oz0PQWz/s2RioUrehUgj/lPNfn" +
       "TwHRHorPcYJz2PyeiXsS4cxS01SO6UrKdfC7/wsH52FW94Ibb1ZmFf2XJv7/" +
       "kY8faqydeeimN3jWL/xHUw/5O51TVe/Z3/NebZg0rXAr68VNgDg/fcxIx8Xv" +
       "3uHIx7+59h8JzguMtJbjBD/hl5flE0ZmhrBA2SVePPQRKMaagvSgCv/20lWC" +
       "81w6ECVevCQ1EB1Agq+1Ron6Udy35CP+Uq6wxtMvtsae6m+Br2rif5w6FU5O" +
       "/HU6Ip84dOPAreevPSIuj2VV2rsXpUyGk7C4xy5USfNDpTmyqjcsvjDl8UkL" +
       "nXqyWSjs7sA5HtDogYA3MLxmB65Vrc7C7eqbh1c/+6sD1a/CyX8riUiMTN1a" +
       "fDOVN3JQnm5NFJ/4oaLk971di7+3Z82y9N/f4nd/RNwQtIbTj8hnjm577d5Z" +
       "h9uiZHIfqYJSmeb5ldn1ezTYF2PmMGlQrJ48qAhSFEn1XSdMwZ0g4Z7lfrHd" +
       "2VDoxb8eINiL71KK/7CB/T9OzfV6TuOppQEqWrfHqZZ9hWbOMAIMbo+9lNgm" +
       "BZDgakA8jiT6DcO5apq8wuBQIJcGMAzcOfwV31r/C/cLHXdUIQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "rzMjkAGDtKY116yXmuRgQNH1aTzgxUTv2+Yy9pZutnR8r7aKO92SJG8V25oY" +
       "GiX4DFVZSj0jWEgdH1sswt6mFSc1gtCX9aHRIc11m2qaw4myTrIpyg07WEk2" +
       "m54zX4W1LKugFY1keRLYFEkxst8fbOdzxcGGkrXQBCa0WvjCpaabLB2rEd4U" +
       "Em87nXQbK5En5+UgHlsCjfYVy7FU3ELTjdOUgMAUEpZdst3U1tUxZQ8bI6sR" +
       "NQdMn5/pbWfb2Q6ZHow3RnW966uTKurC6006rqEtWpmOcbuPy1nP7RsdttZW" +
       "MaMhlFl1ZLUaYsIJmlCTUWGERYiVe5ce4eX6atPaJqusztpxsFHxsuQs7d5S" +
       "lomWmvKzkabU4rrXkbJW1Zr0bHrTaTZwAem3hppVM6P6JiLLPrZam1Qf6003" +
       "JY3IBioc1Sit4jI1tWJZljDGp+3uXJCJ9ay9xJuqL5hKRCMJj8U1qbNBSgiK" +
       "ZCVU2zrYfNgWeQcdcdV+BaPsVUeGqdk0abWaSClbjSrdWrZyBIHUG3qpQvOw" +
       "g7vTVbcfhUucHSWyzeNYj21jusAg5bK4GhrczO3AdQVtKKUxHiBoo9qq0IMV" +
       "yzeIriEqbq8tmS27UXZjtFSGxVGVMpbGckNWa6rI4TNOa1i+KiAhR8QTU2uq" +
       "oYzCqL6ebBBMw4TuWuAyd8QmWWxaIa07WZth+VZsuRzv+lV3ktWFNY8vx0xv" +
       "IRNkmExjWl6M+LTmrL1ySxUsMWh33Hl9QU/AaqpqGVqu0LYpmzV37OhLOSIy" +
       "BHX9dUjR/VLU6sZ9e7MaS23JnmjZaECtYmuYsh61dpARtnBa3LRX7hijrmmx" +
       "TrmMzTvZOjK2gRgH2notNzO6uu6RbS+sWtN4bs+GcJfeOkKbSjrzgMGyhW2i" +
       "C94YRULozV08zjY+MxA2KdJu8hM1mbprX1Fhsu9t1xW6rmW1dNtSeh2h5vB9" +
       "CwT2EaLpJRdfNYNmlVDbdYVYzEKk1KLXNbMeb5eLbr2vS0AmldBDgmazVR0b" +
       "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" +
       "Kyi2jz/x/pdeVpifrOTbKTngOIauxp7/Xba6Vu1TqK4ATO+8eKt8VNyq2J9I" +
       "/M77/+bx6btW730D57RPn6PzPMqfHr3yu/23yz9yAN1zcj5x232Ps0C3zp5K" +
       "XAvVOAnd6ZmziSdPJFtINz+PgI8kC5/f1dtr8yI1FUo+d+h2fLaUv3/qLn2f" +
       "yYufjqEHdTXunt0K31vQJ19rz+k01qLhP93OYO2Iwdqbz+Av3aXvV/LiszsG" +
       "qbN76nsGf/4bZTDfl0WPGETffAZ/+y59n8uLXwceBBik95vze+Z+483Q3q0j" +
       "5m69+cz98V36Pp8Xf7DT3vjkBO0cg3/4DTD4SN6Yn4i8+4jBd7/5DH7hLn1f" +
       "yos/j6HrgMHdhZb9/vuLexb/4htgsbiOQYEHP2IRf6MsfscdWTwoBhzkr+U7" +
       "7V7fY7hxAfg35wAv7THXiwH/Ky/+e7w7Rt/xf8ft8LVnKHuZ/OUbkUkKsO8v" +
       "DeXXHx677X7i7k6d/KmXr9//6Mv8nxb3Zk7uvV2loPu1xLZPHzifql/xQ1Uz" +
       "Cm6u7o6f/eLvn2Loude+zxRDl4v/gux/3EH+cww9cTdIII/87zTI12Lo0QtA" +
       "8pOWonJq/KWDGLpxfjwgpfg/Pe4yEN5+HEC1q5wecj/QNxiSV6/6dzhV2h3y" +
       "p5fOJgonunzktXR5Krd4/kxGUFxGPV69k9111BfkT79M0j/wlcZP7u4QybaY" +
       "ZTmW+ynovt11ppMM4NkLsR3jukK846sPfebqtx1nKw/tCN47zSnanr7zbZ2u" +
       "48fF/ZrsFx/9ue/+zy9/oThI+v9eWB7eJSwAAA==");
}
