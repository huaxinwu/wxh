/**
 * Ambition Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.test;

import org.apache.commons.codec.binary.Base64;

/**
 *
 * @author wxh
 * @version $Id: Base64Test.java, v 0.1 2017年1月16日 上午10:30:48 wxh Exp $
 */
public class Base64Test {
    public static void main(String[] args) {
        String encodingAesKey = "wHXbi5OAjNwGjN9pN89TCGNw6hFOirwNOBx5NJqg3EF";
        byte[] aesKey = Base64.decodeBase64(encodingAesKey + "=");
        System.out.println(new String(aesKey));
    }

}
