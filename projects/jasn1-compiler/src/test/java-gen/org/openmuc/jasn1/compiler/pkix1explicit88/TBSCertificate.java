/**
 * This class file was automatically generated by jASN1 v1.9.1-SNAPSHOT (http://www.openmuc.org)
 */

package org.openmuc.jasn1.compiler.pkix1explicit88;

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


public class TBSCertificate implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final BerTag tag = new BerTag(BerTag.UNIVERSAL_CLASS, BerTag.CONSTRUCTED, 16);

	public byte[] code = null;
	public Version version = null;
	public CertificateSerialNumber serialNumber = null;
	public AlgorithmIdentifier signature = null;
	public Name issuer = null;
	public Validity validity = null;
	public Name subject = null;
	public SubjectPublicKeyInfo subjectPublicKeyInfo = null;
	public UniqueIdentifier issuerUniqueID = null;
	public UniqueIdentifier subjectUniqueID = null;
	public Extensions extensions = null;
	
	public TBSCertificate() {
	}

	public TBSCertificate(byte[] code) {
		this.code = code;
	}

	public TBSCertificate(Version version, CertificateSerialNumber serialNumber, AlgorithmIdentifier signature, Name issuer, Validity validity, Name subject, SubjectPublicKeyInfo subjectPublicKeyInfo, UniqueIdentifier issuerUniqueID, UniqueIdentifier subjectUniqueID, Extensions extensions) {
		this.version = version;
		this.serialNumber = serialNumber;
		this.signature = signature;
		this.issuer = issuer;
		this.validity = validity;
		this.subject = subject;
		this.subjectPublicKeyInfo = subjectPublicKeyInfo;
		this.issuerUniqueID = issuerUniqueID;
		this.subjectUniqueID = subjectUniqueID;
		this.extensions = extensions;
	}

	public int encode(OutputStream os) throws IOException {
		return encode(os, true);
	}

	public int encode(OutputStream os, boolean withTag) throws IOException {

		if (code != null) {
			for (int i = code.length - 1; i >= 0; i--) {
				os.write(code[i]);
			}
			if (withTag) {
				return tag.encode(os) + code.length;
			}
			return code.length;
		}

		int codeLength = 0;
		int sublength;

		if (extensions != null) {
			sublength = extensions.encode(os, true);
			codeLength += sublength;
			codeLength += BerLength.encodeLength(os, sublength);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 3
			os.write(0xA3);
			codeLength += 1;
		}
		
		if (subjectUniqueID != null) {
			codeLength += subjectUniqueID.encode(os, false);
			// write tag: CONTEXT_CLASS, PRIMITIVE, 2
			os.write(0x82);
			codeLength += 1;
		}
		
		if (issuerUniqueID != null) {
			codeLength += issuerUniqueID.encode(os, false);
			// write tag: CONTEXT_CLASS, PRIMITIVE, 1
			os.write(0x81);
			codeLength += 1;
		}
		
		codeLength += subjectPublicKeyInfo.encode(os, true);
		
		codeLength += subject.encode(os);
		
		codeLength += validity.encode(os, true);
		
		codeLength += issuer.encode(os);
		
		codeLength += signature.encode(os, true);
		
		codeLength += serialNumber.encode(os, true);
		
		if (version != null) {
			sublength = version.encode(os, true);
			codeLength += sublength;
			codeLength += BerLength.encodeLength(os, sublength);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 0
			os.write(0xA0);
			codeLength += 1;
		}
		
		codeLength += BerLength.encodeLength(os, codeLength);

		if (withTag) {
			codeLength += tag.encode(os);
		}

		return codeLength;

	}

	public int decode(InputStream is) throws IOException {
		return decode(is, true);
	}

	public int decode(InputStream is, boolean withTag) throws IOException {
		int codeLength = 0;
		int subCodeLength = 0;
		BerTag berTag = new BerTag();

		if (withTag) {
			codeLength += tag.decodeAndCheck(is);
		}

		BerLength length = new BerLength();
		codeLength += length.decode(is);

		int totalLength = length.val;
		if (totalLength == -1) {
			subCodeLength += berTag.decode(is);

			if (berTag.tagNumber == 0 && berTag.tagClass == 0 && berTag.primitive == 0) {
				int nextByte = is.read();
				if (nextByte != 0) {
					if (nextByte == -1) {
						throw new EOFException("Unexpected end of input stream.");
					}
					throw new IOException("Decoded sequence has wrong end of contents octets");
				}
				codeLength += subCodeLength + 1;
				return codeLength;
			}
			if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 0)) {
				codeLength += length.decode(is);
				version = new Version();
				subCodeLength += version.decode(is, true);
				subCodeLength += berTag.decode(is);
			}
			if (berTag.tagNumber == 0 && berTag.tagClass == 0 && berTag.primitive == 0) {
				int nextByte = is.read();
				if (nextByte != 0) {
					if (nextByte == -1) {
						throw new EOFException("Unexpected end of input stream.");
					}
					throw new IOException("Decoded sequence has wrong end of contents octets");
				}
				codeLength += subCodeLength + 1;
				return codeLength;
			}
			if (berTag.equals(CertificateSerialNumber.tag)) {
				serialNumber = new CertificateSerialNumber();
				subCodeLength += serialNumber.decode(is, false);
				subCodeLength += berTag.decode(is);
			}
			if (berTag.tagNumber == 0 && berTag.tagClass == 0 && berTag.primitive == 0) {
				int nextByte = is.read();
				if (nextByte != 0) {
					if (nextByte == -1) {
						throw new EOFException("Unexpected end of input stream.");
					}
					throw new IOException("Decoded sequence has wrong end of contents octets");
				}
				codeLength += subCodeLength + 1;
				return codeLength;
			}
			if (berTag.equals(AlgorithmIdentifier.tag)) {
				signature = new AlgorithmIdentifier();
				subCodeLength += signature.decode(is, false);
				subCodeLength += berTag.decode(is);
			}
			if (berTag.tagNumber == 0 && berTag.tagClass == 0 && berTag.primitive == 0) {
				int nextByte = is.read();
				if (nextByte != 0) {
					if (nextByte == -1) {
						throw new EOFException("Unexpected end of input stream.");
					}
					throw new IOException("Decoded sequence has wrong end of contents octets");
				}
				codeLength += subCodeLength + 1;
				return codeLength;
			}
			issuer = new Name();
			int choiceDecodeLength = issuer.decode(is, berTag);
			if (choiceDecodeLength != 0) {
				subCodeLength += choiceDecodeLength;
				subCodeLength += berTag.decode(is);
			}
			else {
				issuer = null;
			}

			if (berTag.tagNumber == 0 && berTag.tagClass == 0 && berTag.primitive == 0) {
				int nextByte = is.read();
				if (nextByte != 0) {
					if (nextByte == -1) {
						throw new EOFException("Unexpected end of input stream.");
					}
					throw new IOException("Decoded sequence has wrong end of contents octets");
				}
				codeLength += subCodeLength + 1;
				return codeLength;
			}
			if (berTag.equals(Validity.tag)) {
				validity = new Validity();
				subCodeLength += validity.decode(is, false);
				subCodeLength += berTag.decode(is);
			}
			if (berTag.tagNumber == 0 && berTag.tagClass == 0 && berTag.primitive == 0) {
				int nextByte = is.read();
				if (nextByte != 0) {
					if (nextByte == -1) {
						throw new EOFException("Unexpected end of input stream.");
					}
					throw new IOException("Decoded sequence has wrong end of contents octets");
				}
				codeLength += subCodeLength + 1;
				return codeLength;
			}
			subject = new Name();
			choiceDecodeLength = subject.decode(is, berTag);
			if (choiceDecodeLength != 0) {
				subCodeLength += choiceDecodeLength;
				subCodeLength += berTag.decode(is);
			}
			else {
				subject = null;
			}

			if (berTag.tagNumber == 0 && berTag.tagClass == 0 && berTag.primitive == 0) {
				int nextByte = is.read();
				if (nextByte != 0) {
					if (nextByte == -1) {
						throw new EOFException("Unexpected end of input stream.");
					}
					throw new IOException("Decoded sequence has wrong end of contents octets");
				}
				codeLength += subCodeLength + 1;
				return codeLength;
			}
			if (berTag.equals(SubjectPublicKeyInfo.tag)) {
				subjectPublicKeyInfo = new SubjectPublicKeyInfo();
				subCodeLength += subjectPublicKeyInfo.decode(is, false);
				subCodeLength += berTag.decode(is);
			}
			if (berTag.tagNumber == 0 && berTag.tagClass == 0 && berTag.primitive == 0) {
				int nextByte = is.read();
				if (nextByte != 0) {
					if (nextByte == -1) {
						throw new EOFException("Unexpected end of input stream.");
					}
					throw new IOException("Decoded sequence has wrong end of contents octets");
				}
				codeLength += subCodeLength + 1;
				return codeLength;
			}
			if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 1)) {
				issuerUniqueID = new UniqueIdentifier();
				subCodeLength += issuerUniqueID.decode(is, false);
				subCodeLength += berTag.decode(is);
			}
			if (berTag.tagNumber == 0 && berTag.tagClass == 0 && berTag.primitive == 0) {
				int nextByte = is.read();
				if (nextByte != 0) {
					if (nextByte == -1) {
						throw new EOFException("Unexpected end of input stream.");
					}
					throw new IOException("Decoded sequence has wrong end of contents octets");
				}
				codeLength += subCodeLength + 1;
				return codeLength;
			}
			if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 2)) {
				subjectUniqueID = new UniqueIdentifier();
				subCodeLength += subjectUniqueID.decode(is, false);
				subCodeLength += berTag.decode(is);
			}
			if (berTag.tagNumber == 0 && berTag.tagClass == 0 && berTag.primitive == 0) {
				int nextByte = is.read();
				if (nextByte != 0) {
					if (nextByte == -1) {
						throw new EOFException("Unexpected end of input stream.");
					}
					throw new IOException("Decoded sequence has wrong end of contents octets");
				}
				codeLength += subCodeLength + 1;
				return codeLength;
			}
			if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 3)) {
				codeLength += length.decode(is);
				extensions = new Extensions();
				subCodeLength += extensions.decode(is, true);
				subCodeLength += berTag.decode(is);
			}
			int nextByte = is.read();
			if (berTag.tagNumber != 0 || berTag.tagClass != 0 || berTag.primitive != 0
			|| nextByte != 0) {
				if (nextByte == -1) {
					throw new EOFException("Unexpected end of input stream.");
				}
				throw new IOException("Decoded sequence has wrong end of contents octets");
			}
			codeLength += subCodeLength + 1;
			return codeLength;
		}

		codeLength += totalLength;

		subCodeLength += berTag.decode(is);
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 0)) {
			subCodeLength += length.decode(is);
			version = new Version();
			subCodeLength += version.decode(is, true);
			subCodeLength += berTag.decode(is);
		}
		
		if (berTag.equals(CertificateSerialNumber.tag)) {
			serialNumber = new CertificateSerialNumber();
			subCodeLength += serialNumber.decode(is, false);
			subCodeLength += berTag.decode(is);
		}
		else {
			throw new IOException("Tag does not match the mandatory sequence element tag.");
		}
		
		if (berTag.equals(AlgorithmIdentifier.tag)) {
			signature = new AlgorithmIdentifier();
			subCodeLength += signature.decode(is, false);
			subCodeLength += berTag.decode(is);
		}
		else {
			throw new IOException("Tag does not match the mandatory sequence element tag.");
		}
		
		issuer = new Name();
		subCodeLength += issuer.decode(is, berTag);
		subCodeLength += berTag.decode(is);
		
		if (berTag.equals(Validity.tag)) {
			validity = new Validity();
			subCodeLength += validity.decode(is, false);
			subCodeLength += berTag.decode(is);
		}
		else {
			throw new IOException("Tag does not match the mandatory sequence element tag.");
		}
		
		subject = new Name();
		subCodeLength += subject.decode(is, berTag);
		subCodeLength += berTag.decode(is);
		
		if (berTag.equals(SubjectPublicKeyInfo.tag)) {
			subjectPublicKeyInfo = new SubjectPublicKeyInfo();
			subCodeLength += subjectPublicKeyInfo.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
			subCodeLength += berTag.decode(is);
		}
		else {
			throw new IOException("Tag does not match the mandatory sequence element tag.");
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 1)) {
			issuerUniqueID = new UniqueIdentifier();
			subCodeLength += issuerUniqueID.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
			subCodeLength += berTag.decode(is);
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 2)) {
			subjectUniqueID = new UniqueIdentifier();
			subCodeLength += subjectUniqueID.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
			subCodeLength += berTag.decode(is);
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 3)) {
			subCodeLength += length.decode(is);
			extensions = new Extensions();
			subCodeLength += extensions.decode(is, true);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
		}
		throw new IOException("Unexpected end of sequence, length tag: " + totalLength + ", actual sequence length: " + subCodeLength);

		
	}

	public void encodeAndSave(int encodingSizeGuess) throws IOException {
		ReverseByteArrayOutputStream os = new ReverseByteArrayOutputStream(encodingSizeGuess);
		encode(os, false);
		code = os.getArray();
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		appendAsString(sb, 0);
		return sb.toString();
	}

	public void appendAsString(StringBuilder sb, int indentLevel) {

		sb.append("{");
		boolean firstSelectedElement = true;
		if (version != null) {
			sb.append("\n");
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("version: ").append(version);
			firstSelectedElement = false;
		}
		
		if (!firstSelectedElement) {
			sb.append(",\n");
		}
		for (int i = 0; i < indentLevel + 1; i++) {
			sb.append("\t");
		}
		if (serialNumber != null) {
			sb.append("serialNumber: ").append(serialNumber);
		}
		else {
			sb.append("serialNumber: <empty-required-field>");
		}
		
		sb.append(",\n");
		for (int i = 0; i < indentLevel + 1; i++) {
			sb.append("\t");
		}
		if (signature != null) {
			sb.append("signature: ");
			signature.appendAsString(sb, indentLevel + 1);
		}
		else {
			sb.append("signature: <empty-required-field>");
		}
		
		sb.append(",\n");
		for (int i = 0; i < indentLevel + 1; i++) {
			sb.append("\t");
		}
		if (issuer != null) {
			sb.append("issuer: ");
			issuer.appendAsString(sb, indentLevel + 1);
		}
		else {
			sb.append("issuer: <empty-required-field>");
		}
		
		sb.append(",\n");
		for (int i = 0; i < indentLevel + 1; i++) {
			sb.append("\t");
		}
		if (validity != null) {
			sb.append("validity: ");
			validity.appendAsString(sb, indentLevel + 1);
		}
		else {
			sb.append("validity: <empty-required-field>");
		}
		
		sb.append(",\n");
		for (int i = 0; i < indentLevel + 1; i++) {
			sb.append("\t");
		}
		if (subject != null) {
			sb.append("subject: ");
			subject.appendAsString(sb, indentLevel + 1);
		}
		else {
			sb.append("subject: <empty-required-field>");
		}
		
		sb.append(",\n");
		for (int i = 0; i < indentLevel + 1; i++) {
			sb.append("\t");
		}
		if (subjectPublicKeyInfo != null) {
			sb.append("subjectPublicKeyInfo: ");
			subjectPublicKeyInfo.appendAsString(sb, indentLevel + 1);
		}
		else {
			sb.append("subjectPublicKeyInfo: <empty-required-field>");
		}
		
		if (issuerUniqueID != null) {
			sb.append(",\n");
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("issuerUniqueID: ").append(issuerUniqueID);
		}
		
		if (subjectUniqueID != null) {
			sb.append(",\n");
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("subjectUniqueID: ").append(subjectUniqueID);
		}
		
		if (extensions != null) {
			sb.append(",\n");
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("extensions: ");
			extensions.appendAsString(sb, indentLevel + 1);
		}
		
		sb.append("\n");
		for (int i = 0; i < indentLevel; i++) {
			sb.append("\t");
		}
		sb.append("}");
	}

}

