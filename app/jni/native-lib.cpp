//#include <jni.h>
//#include <string>
//
//extern "C" JNIEXPORT jstring JNICALL
//Java_org_untitled_sergey_untitled2_MainActivity_stringFromJNI(
//        JNIEnv *env,
//        jobject /* this */) {
//    std::string hello = "Hello from C++";
//    return env->NewStringUTF(hello.c_str());
//}

#include <string.h>
#include <jni.h>
#include <android/log.h>
#include <gst/gst.h>

#include "string"

extern "C" JNIEXPORT jstring JNICALL
Java_org_untitled_sergey_untitled2_MainActivity_getGstreamerInfo (JNIEnv* env, jobject thiz) {
    char *version_utf8 = gst_version_string();
    std::string s(version_utf8);
    g_free (version_utf8);
    return env->NewStringUTF(s.c_str());
}