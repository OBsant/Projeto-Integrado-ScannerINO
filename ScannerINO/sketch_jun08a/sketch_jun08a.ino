#include <usbhid.h>                          
#include <hiduniversal.h>                 
#include <usbhub.h>

#include <avr/pgmspace.h>
#include <Usb.h>
#include <usbhub.h>
#include <avr/pgmspace.h>
#include <hidboot.h>


USB     Usb;
USBHub     Hub(&Usb);                                         
HIDUniversal      Hid(&Usb);                                  
HIDBoot<USB_HID_PROTOCOL_KEYBOARD>    Keyboard(&Usb);

class KbdRptParser : public KeyboardReportParser
{
      void PrintKey(uint8_t mod, uint8_t key);           
protected:
virtual void OnKeyDown (uint8_t mod, uint8_t key);
virtual void OnKeyPressed(uint8_t key);
};

void KbdRptParser::OnKeyDown(uint8_t mod, uint8_t key) 
{
  uint8_t c = OemToAscii(mod, key);

  if (c)
      OnKeyPressed(c);
}

void KbdRptParser::OnKeyPressed(uint8_t key) 
{
static uint32_t next_time = 0;    
static uint8_t current_cursor = 0;  

  Serial.print( (char)key );
};

KbdRptParser Prs;

void setup()
{
  Serial.begin( 115200 );
  if (Usb.Init() == -1) {
      Serial.println("Não iniciado");
  }

  delay( 200 );
  Hid.SetReportParser(0, (HIDReportParser*)&Prs);
  
}

void loop()
{
Usb.Task();
}
