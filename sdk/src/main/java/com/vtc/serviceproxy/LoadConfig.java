package com.vtc.serviceproxy;

import java.io.IOException;
import java.util.Properties;

public interface LoadConfig {
	Properties gaLoadConfig() throws IOException ;
	Properties googleIAPConfig() throws IOException ;
}
