LOCAL_PATH := $(call my-dir)
include $(CLEAR_VARS)

LOCAL_SRC_FILES := \
    MACLib\APECompress.cpp \
    MACLib\APECompressCore.cpp \
    MACLib\APECompressCreate.cpp \
    MACLib\APEDecompress.cpp \
    MACLib\APEHeader.cpp \
    MACLib\APEInfo.cpp \
    MACLib\APELink.cpp \
    MACLib\APESimple.cpp \
    MACLib\APETag.cpp \
    MACLib\BitArray.cpp \
    MACLib\MACLib.cpp \
    MACLib\MACProgressHelper.cpp \
    MACLib\md5.cpp \
    MACLib\NewPredictor.cpp \
    MACLib\NNFilter.cpp \
    MACLib\Prepare.cpp \
    MACLib\UnBitArray.cpp \
    MACLib\UnBitArrayBase.cpp \
    MACLib\WAVInputSource.cpp \
	com_cloverstudio_mediaplayer_ApeDecoder.cpp


LOCAL_SRC_FILES += \
	Shared\CharacterHelper.cpp \
	Shared\CircleBuffer.cpp \
	Shared\GlobalFunctions.cpp \
	Shared\StdLibFileIO.cpp \
	Shared\WinFileIO.cpp

LOCAL_C_INCLUDES := \
    $(LOCAL_PATH)\Shared \
	$(LOCAL_PATH)\MACLib
	
LOCAL_CFLAGS := -fexceptions
LOCAL_LDLIBS := -llog
LOCAL_SHARED_LIBRARIES := libstlport libutils

LOCAL_MODULE := libapedec

include $(BUILD_SHARED_LIBRARY)

include $(call all-makefiles-under, $(LOCAL_PATH))
