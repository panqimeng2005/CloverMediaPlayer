
#include <jni.h>
#include <assert.h>
#include <android/log.h>

#include "APEDecompress.h"
#include "APEInfo.h"
#include "CharacterHelper.h"
#include "MACLib.h"


#define LOG_TAG "ApeDecoder"
#define LOGI(msg) __android_log_print(ANDROID_LOG_INFO, LOG_TAG, msg);

using namespace APE;

struct fields_t {
	jfieldID context;
};

static fields_t fields;

static const char* const gClassApeDecoderName =
		"com/cloverstudio/mediaplayer/ApeDecoder";

static void setApeDecompress(JNIEnv *env, jobject thiz, IAPEDecompress* pDecompressor) {
	IAPEDecompress* pOld = (IAPEDecompress*)env->GetIntField(thiz, fields.context);
	if (pOld != NULL) {
		delete pOld;
	}
	env->SetIntField(thiz, fields.context, (int)(pDecompressor));
}


static void com_cloverstudio_mediaplayer_ApeDecoder_setDataSource(JNIEnv *env, jobject thiz, jstring path) {
	LOGI("com_cloverstudio_mediaplayer_ApeDecoder_setDataSource");
}


static void com_cloverstudio_mediaplayer_ApeDecoder_getData(JNIEnv *env, jobject thiz, jbyteArray buf, jint len) {
	LOGI("com_cloverstudio_mediaplayer_ApeDecoder_getData");
}

static int com_cloverstudio_mediaplayer_ApeDecoder_getMediaInfo(JNIEnv *env, jobject thiz, jobject info) {
	LOGI("com_cloverstudio_mediaplayer_ApeDecoder_getMediaInfo");
	return 0;
}

static void com_cloverstudio_mediaplayer_ApeDecoder_native_setup(JNIEnv *env, jobject thiz) {
	LOGI("com_cloverstudio_mediaplayer_ApeDecoder_native_setup");
}

static void com_cloverstudio_mediaplayer_ApeDecoder_native_finalize(JNIEnv *env, jobject thiz) {
	LOGI("com_cloverstudio_mediaplayer_ApeDecoder_native_finalize");
}

static void com_cloverstudio_mediaplayer_ApeDecoder_native_init(JNIEnv *env) {
	LOGI("com_cloverstudio_mediaplayer_ApeDecoder_native_init");
	jclass clazz = env->FindClass(gClassApeDecoderName);
	if (clazz == NULL) {
		return;
	}
	fields.context = env->GetFieldID(clazz, "mNativeContext", "I");
	if (fields.context == NULL) {
		return;
	}
}


static JNINativeMethod gMethods[] = {
	{"native_init", "()V", (void *)com_cloverstudio_mediaplayer_ApeDecoder_native_init},
};

jint register_com_cloverstudio_mediaplayer_ApeDecoder(JNIEnv* env) {
	jclass clazz;
	LOGI("native register_com_cloverstudio_mediaplayer_ApeDecoder");
	clazz = env->FindClass(gClassApeDecoderName);
	if (clazz == NULL) {
		return JNI_FALSE;
	}
	if (env->RegisterNatives(clazz, gMethods, sizeof(gMethods)/sizeof(gMethods[0])) < 0) {
		return JNI_FALSE;
	}
	return JNI_TRUE;
}



jint JNI_OnLoad(JavaVM* vm, void* reserved) {
	JNIEnv* env = NULL;
	jint result = -1;

	LOGI("native JNI_OnLoad");

	if (vm->GetEnv((void**) &env, JNI_VERSION_1_4) != JNI_OK) {
		LOGI("ERROR: GetEnv failed");
		goto bail;
	}

	assert(env != NULL);

	if (register_com_cloverstudio_mediaplayer_ApeDecoder(env) < 0) {
		LOGI("ERROR: register_com_cloverstudio_mediaplayer_ApeDecoder failed");
		goto bail;
	}

	result = JNI_VERSION_1_4;

bail:
	return result;
}


