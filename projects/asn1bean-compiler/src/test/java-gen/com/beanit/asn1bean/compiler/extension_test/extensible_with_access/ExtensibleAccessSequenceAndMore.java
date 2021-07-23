/*
 * This class file was automatically generated by ASN1bean (http://www.beanit.com)
 */

package com.beanit.asn1bean.compiler.extension_test.extensible_with_access;

import java.io.IOException;
import java.io.EOFException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.io.Serializable;
import com.beanit.asn1bean.ber.*;
import com.beanit.asn1bean.ber.types.*;
import com.beanit.asn1bean.ber.types.string.*;


public class ExtensibleAccessSequenceAndMore implements BerType, Serializable {

	private static final long serialVersionUID = 1L;

	public static final BerTag tag = new BerTag(BerTag.UNIVERSAL_CLASS, BerTag.CONSTRUCTED, 16);

	private byte[] code = null;
	private ExtensibleAccessSequence extensibleSequence = null;
	private BerVisibleString more = null;
	
	private byte[] extensionBytes = null;
	public ExtensibleAccessSequenceAndMore() {
	}

	public ExtensibleAccessSequenceAndMore(byte[] code) {
		this.code = code;
	}

	public void setExtensibleSequence(ExtensibleAccessSequence extensibleSequence) {
		this.extensibleSequence = extensibleSequence;
	}

	public ExtensibleAccessSequence getExtensibleSequence() {
		return extensibleSequence;
	}

	public void setMore(BerVisibleString more) {
		this.more = more;
	}

	public BerVisibleString getMore() {
		return more;
	}

	public byte[] getExtensionBytes() {
		return extensionBytes;
	}

	public void setExtensionBytes(byte[] bytes) {
		this.extensionBytes = bytes;
	}

	@Override public int encode(OutputStream reverseOS) throws IOException {
		return encode(reverseOS, true);
	}

	public int encode(OutputStream reverseOS, boolean withTag) throws IOException {

		if (code != null) {
			reverseOS.write(code);
			if (withTag) {
				return tag.encode(reverseOS) + code.length;
			}
			return code.length;
		}

		int codeLength = 0;
		if (extensionBytes != null) {
			reverseOS.write(extensionBytes);
			codeLength += extensionBytes.length;
		}

		codeLength += more.encode(reverseOS, true);
		
		codeLength += extensibleSequence.encode(reverseOS, true);
		
		codeLength += BerLength.encodeLength(reverseOS, codeLength);

		if (withTag) {
			codeLength += tag.encode(reverseOS);
		}

		return codeLength;

	}

	@Override public int decode(InputStream is) throws IOException {
		return decode(is, true);
	}

	public int decode(InputStream is, boolean withTag) throws IOException {
		int tlByteCount = 0;
		int vByteCount = 0;
		BerTag berTag = new BerTag();

		if (withTag) {
			tlByteCount += tag.decodeAndCheck(is);
		}

		BerLength length = new BerLength();
		tlByteCount += length.decode(is);
		int lengthVal = length.val;
		vByteCount += berTag.decode(is);

		if (berTag.equals(ExtensibleAccessSequence.tag)) {
			extensibleSequence = new ExtensibleAccessSequence();
			vByteCount += extensibleSequence.decode(is, false);
			vByteCount += berTag.decode(is);
		}
		else {
			throw new IOException("Tag does not match mandatory sequence component.");
		}
		
		if (berTag.equals(BerVisibleString.tag)) {
			more = new BerVisibleString();
			vByteCount += more.decode(is, false);
			if (lengthVal >= 0 && vByteCount == lengthVal) {
				return tlByteCount + vByteCount;
			}
			vByteCount += berTag.decode(is);
		}
		else {
			throw new IOException("Tag does not match mandatory sequence component.");
		}
		
		if (lengthVal < 0) {
			if (!berTag.equals(0, 0, 0)) {
				ByteArrayOutputStream os = new ByteArrayOutputStream();
				while (!berTag.equals(0, 0, 0)) {
					berTag.encodeForwards(os);
					vByteCount += DecodeUtil.decodeUnknownComponent(is,os);
					vByteCount += berTag.decode(is);
				}
				extensionBytes = os.toByteArray();
			}
			vByteCount += BerLength.readEocByte(is);
			return tlByteCount + vByteCount;
		} else {
			ByteArrayOutputStream os = new ByteArrayOutputStream();
			while (vByteCount < lengthVal) {
				berTag.encodeForwards(os);
				vByteCount += DecodeUtil.decodeUnknownComponent(is, os);
				if (vByteCount == lengthVal) {
					extensionBytes = os.toByteArray();
					return tlByteCount + vByteCount;
				}
				vByteCount += berTag.decode(is);
			}
		}
		throw new IOException("Unexpected end of sequence, length tag: " + lengthVal + ", bytes decoded: " + vByteCount);
	}

	public void encodeAndSave(int encodingSizeGuess) throws IOException {
		ReverseByteArrayOutputStream reverseOS = new ReverseByteArrayOutputStream(encodingSizeGuess);
		encode(reverseOS, false);
		code = reverseOS.getArray();
	}

	@Override public String toString() {
		StringBuilder sb = new StringBuilder();
		appendAsString(sb, 0);
		return sb.toString();
	}

	public void appendAsString(StringBuilder sb, int indentLevel) {

		sb.append("{");
		sb.append("\n");
		for (int i = 0; i < indentLevel + 1; i++) {
			sb.append("\t");
		}
		if (extensibleSequence != null) {
			sb.append("extensibleSequence: ");
			extensibleSequence.appendAsString(sb, indentLevel + 1);
		}
		else {
			sb.append("extensibleSequence: <empty-required-field>");
		}
		
		sb.append(",\n");
		for (int i = 0; i < indentLevel + 1; i++) {
			sb.append("\t");
		}
		if (more != null) {
			sb.append("more: ").append(more);
		}
		else {
			sb.append("more: <empty-required-field>");
		}
		
		sb.append("\n");
		for (int i = 0; i < indentLevel; i++) {
			sb.append("\t");
		}
		sb.append("}");
	}

}

