//package com.osprey.bkob.del;
//
//import java.security.SecureRandom;
//import java.sql.Timestamp;
//
//public class TokenGenerator {
//
//        private static SecureRandom random = new SecureRandom();
//
//        public static String generateToken(String email) {
//                long longToken = Math.abs(random.nextLong());
//                String random = Long.toString(longToken, 16);
//                return (new Timestamp(System.currentTimeMillis())
//                        .getTime() + "_" + email + "_" + random);
//        }
//
//}
