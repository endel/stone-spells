package com.stonespells.core;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public interface Serializable {
	byte[] toByteArray();
	void readFromStream(DataInputStream dis) throws Exception;
	void writeToStream(DataOutputStream dos) throws Exception;
	void fromByteArray(byte[] bytes);
}
