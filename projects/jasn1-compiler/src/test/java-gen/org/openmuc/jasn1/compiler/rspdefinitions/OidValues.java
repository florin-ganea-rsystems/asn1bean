/**
 * This class file was automatically generated by jASN1 v1.9.1-SNAPSHOT (http://www.openmuc.org)
 */

package org.openmuc.jasn1.compiler.rspdefinitions;

import java.io.IOException;
import java.io.EOFException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.io.Serializable;
import org.openmuc.jasn1.ber.*;
import org.openmuc.jasn1.ber.types.*;
import org.openmuc.jasn1.ber.types.string.*;

import org.openmuc.jasn1.compiler.pkix1explicit88.Certificate;
import org.openmuc.jasn1.compiler.pkix1explicit88.CertificateList;
import org.openmuc.jasn1.compiler.pkix1explicit88.Time;
import org.openmuc.jasn1.compiler.pkix1implicit88.SubjectKeyIdentifier;

public final class OidValues {
	public static final BerObjectIdentifier idRsp = new BerObjectIdentifier(new int[]{2, 23, 146, 1});
	public static final BerObjectIdentifier idRspCertObjects = new BerObjectIdentifier(new int[]{2, 23, 146, 1, 2});
	public static final BerObjectIdentifier idRspExpDate = new BerObjectIdentifier(new int[]{2, 23, 146, 1, 2, 0, 1});
	public static final BerObjectIdentifier idRspPartialCrlNumber = new BerObjectIdentifier(new int[]{2, 23, 146, 1, 2, 0, 3});
	public static final BerObjectIdentifier idRspTotalPartialCrlNumber = new BerObjectIdentifier(new int[]{2, 23, 146, 1, 2, 0, 2});
	public static final BerObjectIdentifier idRspExt = new BerObjectIdentifier(new int[]{2, 23, 146, 1, 2, 0});
	public static final BerObjectIdentifier idRspRole = new BerObjectIdentifier(new int[]{2, 23, 146, 1, 2, 1});
	public static final BerObjectIdentifier idRspRoleCi = new BerObjectIdentifier(new int[]{2, 23, 146, 1, 2, 1, 0});
	public static final BerObjectIdentifier idRspRoleDpAuth = new BerObjectIdentifier(new int[]{2, 23, 146, 1, 2, 1, 4});
	public static final BerObjectIdentifier idRspRoleDpPb = new BerObjectIdentifier(new int[]{2, 23, 146, 1, 2, 1, 5});
	public static final BerObjectIdentifier idRspRoleDpTls = new BerObjectIdentifier(new int[]{2, 23, 146, 1, 2, 1, 3});
	public static final BerObjectIdentifier idRspRoleDsAuth = new BerObjectIdentifier(new int[]{2, 23, 146, 1, 2, 1, 7});
	public static final BerObjectIdentifier idRspRoleDsTls = new BerObjectIdentifier(new int[]{2, 23, 146, 1, 2, 1, 6});
	public static final BerObjectIdentifier idRspRoleEuicc = new BerObjectIdentifier(new int[]{2, 23, 146, 1, 2, 1, 1});
	public static final BerObjectIdentifier idRspRoleEum = new BerObjectIdentifier(new int[]{2, 23, 146, 1, 2, 1, 2});
}
