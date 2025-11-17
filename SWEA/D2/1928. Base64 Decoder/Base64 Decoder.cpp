#include <iostream>
#include <string>

using namespace std;

int decode_table[128];

void build_decode_table() {
    for(int i = 0; i <= 25; ++i) {
        decode_table['A' + i] = i;
    }
    for(int i = 0; i <= 25; ++i) {
        decode_table['a' + i] = i + 26;
    }
    for(int i = 0; i <= 9; ++i) {
        decode_table['0' + i] = i + 52;
    }
    decode_table['+'] = 62;
    decode_table['/'] = 63;
}

int main() {
    int T;

    cin >> T;

    build_decode_table();

    for(int t = 1; t <= T; ++t) {
        string encoded_str;
        string decoded_str = "";

        cin >> encoded_str;

        for(int i = 0; i < encoded_str.size(); i += 4) {
            char c1 = encoded_str[i];
            char c2 = encoded_str[i + 1];
            char c3 = encoded_str[i + 2];
            char c4 = encoded_str[i + 3];

            int val1 = decode_table[c1];
            int val2 = decode_table[c2];
            int val3 = decode_table[c3];
            int val4 = decode_table[c4];

            int tmp_24bit = (val1 << 18) | (val2 << 12) | (val3 << 6) | (val4);

            int byte1 = (tmp_24bit >> 16) & 0xff;
            int byte2 = (tmp_24bit >> 8) & 0xff;
            int byte3 = (tmp_24bit) & 0xff;

            decoded_str += (char)byte1;
            decoded_str += (char)byte2;
            decoded_str += (char)byte3;
        }

        cout << '#' << t << ' ' << decoded_str << '\n';
    }
}