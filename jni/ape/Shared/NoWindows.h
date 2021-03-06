#pragma once

#if !defined(PLATFORM_WINDOWS)

// we treat BOOL as a global type, so don't declare it in the namespace
typedef int                 BOOL;

namespace APE
{

#define FALSE    0
#define TRUE     1

#define NEAR
#define FAR

typedef unsigned long       DWORD;
typedef unsigned char       BYTE;
typedef unsigned short      WORD;
typedef float               FLOAT;
typedef void *              HANDLE;
typedef unsigned int        UINT;
typedef unsigned int        WPARAM;
typedef long                LPARAM;
typedef const char *        LPCSTR;
typedef char *              LPSTR;
typedef long                LRESULT;

#define ZeroMemory(POINTER, BYTES) memset(POINTER, 0, BYTES);
#define max(a,b)    (((a) > (b)) ? (a) : (b))
#define min(a,b)    (((a) < (b)) ? (a) : (b))

#define __stdcall
#define CALLBACK

#define _T(x) L ## x

#define _stricmp strcasecmp
#define _strnicmp strncasecmp
#define _wcsicmp wcscasecmp
#define _wcsnicmp wcsncasecmp

// panqimeng add for compile
extern "C" {
	int wcscasecmp(const wchar_t*, const wchar_t*);
	int wcsncasecmp(const wchar_t*, const wchar_t*, size_t);
}

#define _wtoi(x) wcstol(x, NULL, 10)
#define _tcscat wcscat

#define _FPOSOFF(fp) (fp)
#define MAX_PATH    260

}

#endif // #ifndef _WIN32
